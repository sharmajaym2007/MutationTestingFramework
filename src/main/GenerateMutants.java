package main;

import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

public class GenerateMutants {
	final static Logger logger = Logger.getLogger(GenerateMutants.class);

	static int maxMutants = Integer.MAX_VALUE;

	static List<ASTVisitor> mutantCreators = AllVisitors.getVisitors();

	public static void main(String ar[]) {
		try {
			ProjectUtility.projPrefix = ar[0];
			System.out.println(ProjectUtility.projPrefix);
			ProjectUtility.mutantPrefix = ProjectUtility.projPrefix.substring(0,
					ProjectUtility.projPrefix.replaceAll(" ", "").lastIndexOf("\\"));

			ProjectUtility.cleanUp();
			String className, funcName;
			int statementNo;
			ASTVisitor visitor;
			HashSet<String> validateChange = new HashSet<String>();
			List<String> fileList = ProjectUtility.getAllFiles();

			boolean isMutantCreated = false;
			logger.debug("-------- MUTANT GENERATION TASK STARTED ------------ ");
			int mutantCounter = 0;

			for (int currentMutant = 1; currentMutant <= maxMutants; currentMutant++) {
				isMutantCreated = false;
				for (String file : fileList) {
					if (isMutantCreated) {
						logger.debug("Ignoring File " + file);
						break;
					}

					String currFilePath = ProjectUtility.projPrefix + file;
					File currFile = new File(currFilePath);
					String data = FileUtils.readFileToString(currFile);

					ASTParser parser = ASTParser.newParser(AST.JLS3);
					parser.setSource(data.toCharArray());
					parser.setKind(ASTParser.K_COMPILATION_UNIT);

					CompilationUnit cunit = (CompilationUnit) parser.createAST(null);
					cunit.recordModifications();

					Document currDoc = new Document(data);

					for (int j = 0; j < cunit.types().size() & !isMutantCreated; j++) {
						MethodDeclaration currFunc;
						Block block;

						TypeDeclaration typeDec = (TypeDeclaration) cunit.types().get(0);
						className = typeDec.getName().toString();
						for (int i = 0; i < typeDec.getMethods().length && !isMutantCreated; i++) {
							currFunc = typeDec.getMethods()[i];
							funcName = currFunc.getName().toString();
							block = currFunc.getBody();

							if (block == null)
								continue;
							@SuppressWarnings("unchecked")
							List<Statement> stmtList = block.statements();

							for (statementNo = 0; statementNo < stmtList.size() && !isMutantCreated; statementNo++) {
								for (int vNo = 0; vNo < mutantCreators.size() && !isMutantCreated; vNo++) {
									visitor = mutantCreators.get(vNo);
									if (validateChange.contains(file + "*" + className + "*" + funcName + "*"
											+ statementNo + "*" + visitor.getClass().toString())) {
										continue;
									}
									// logger.debug("Current visitor:
									// "+visitor.getClass().getName());
									Statement currStmnt = stmtList.get(statementNo);
									String oldStatement, newStatement;

									oldStatement = currStmnt.toString();
									currStmnt.accept(visitor);
									newStatement = currStmnt.toString();

									if (!(newStatement.equals(oldStatement))) {
										validateChange.add(file + "*" + className + "*" + funcName + "*" + statementNo
												+ "*" + visitor.getClass().toString());
										isMutantCreated = true;
										ProjectUtility.createCopy(++mutantCounter);
										String currMutantPath = ProjectUtility.mutantPrefix + "\\mutants\\"
												+ ProjectUtility.projPrefix
														.substring(ProjectUtility.projPrefix.lastIndexOf("\\") + 1)
												+ ProjectUtility.SEPARATOR + mutantCounter;
										logger.debug("Working on file: " + (currMutantPath + file));
										logger.debug("Old Statement: " + oldStatement);
										logger.debug("New Statement: " + newStatement);
										logger.debug(">>>>>>> Created Mutant# " + mutantCounter + " ----- : "
												+ currMutantPath);
										File mFile = new File(currMutantPath + file);
										TextEdit editedText = cunit.rewrite(currDoc, null);
										editedText.apply(currDoc);

										FileWriter updatedFile = new FileWriter(mFile, false);
										updatedFile.write(currDoc.get());
										updatedFile.close();
									}
								}
							}
						}
					}
				}

				if (!isMutantCreated) {
					logger.debug("No changes identified for mutation");
					break;
				}
			}
			logger.debug("-------- MUTANT GENERATION TASK COMPLETED SUCCESSFULLY ------------ ");
		} catch (Exception e) {
			logger.error("Undefined Exception");
			e.printStackTrace();
		}
	}
}
