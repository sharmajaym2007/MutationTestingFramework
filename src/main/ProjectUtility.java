package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ProjectUtility {

	static String SEPARATOR = "_";
	// static String projPrefix = "E:/UTD/5-Fall 2016/Testing" +
	// "/Project/MutationCode/dataset/cucumber-reporting";
	static String projPrefix;
	static String mutantPrefix;
	static List<String> fileList = new ArrayList<String>();

	public static void createCopy(int mutantNo) throws IOException {
		FileUtils.copyDirectory(new File(projPrefix), new File(mutantPrefix + "\\mutants\\"
				+ projPrefix.substring(projPrefix.lastIndexOf("\\") + 1) + SEPARATOR + mutantNo));
	}

	public static void deleteCopy(int mutantNo) throws IOException {
		FileUtils.deleteDirectory(new File(mutantPrefix + SEPARATOR + mutantNo));
	}

	public static List<String> getAllFiles() {
		getFilesRecursive(new File(projPrefix + "\\src\\main\\java"));
		return fileList;
	}

	private static void getFilesRecursive(File projFiles) {
		for (File files : projFiles.listFiles()) {
			if (files.isDirectory()) {
				getFilesRecursive(files);
			}
			// Add only *.java files for mutant generation
			else if (files.getName().endsWith(".java")) {
				// System.out.println("files: " + files.getAbsolutePath());
				// System.out.println("proj prefix: " + projPrefix);
				fileList.add(files.getAbsolutePath().substring(projPrefix.length()));
			}
		}
	}

	public static void cleanUp() {
		try {
			File f = new File(mutantPrefix + "\\mutants");
			if (f.exists()) {
				for (File curr : f.listFiles()) {
					if (curr.isDirectory() && curr.getName().contains(SEPARATOR))
						FileUtils.deleteDirectory(curr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
