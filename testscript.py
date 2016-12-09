#!/usr/bin/python3

import subprocess
import os
import sys

# Mutation Generation 

#path = input("Enter tool path: ")
#projPath = input("Enter project path (For Ex: E:\\mutation\\dataset\\cucumber-reporting) -- ")

projPath = "E:\\mutation\\dataset\\cucumber-reporting"
mutantPath = projPath[0:projPath.rfind("\\")]

print ("*** MUTANT GENERATION STARTED **** ")
subprocess.call(['java', '-Dlog4j.configuration=resources/log4j.properties','-jar', 'mutants.jar', projPath])
print ("*** MUTANT GENERATION COMPLETED **** ")

print ("*** MUTATION TESTING STARTED **** ")
mutantCount = 0
lists = os.listdir(mutantPath+"\\mutants")
mdirs = []
for f in lists:
	if "." not in f and "_" in f:
		mutantCount+=1
		mdirs.append(f)

print (" ------> Total Mutants = "+str(len(mdirs)))

#Iterate through each mutant
status = 0
count = 0
liveCount = 0
args = ['mvn', 'test', '-q']
for curr in mdirs:
	count+=1
	print "Executing mutant("+ str(count) +"): " + mutantPath+"\\mutants\\" + curr,
	status = 0
	os.chdir(mutantPath+"\\mutants\\"+curr)
	FNULL = open(os.devnull,"w")
	process = subprocess.call(args,shell=True,stdout=FNULL)
	
	if process == 0:
		status = 1
		print (" ----> Mutant not killed")
	else:
		print (" ----> Mutant killed")
	liveCount+=status
	
totalKilled = mutantCount - liveCount
mutationScore = format(float(totalKilled)/float(mutantCount),'.3f')

print ("***** MUTATION REPORT ********* ")
print ("> Total Mutants: "+str(mutantCount))
print ("> Total Killed Mutants: "+str(totalKilled))
print ("> Total Live Mutants: "+str(liveCount))
print ("> Mutation Score: "+str(mutationScore))

os.chdir(sys.path[0])
file = open("report.txt", "w")
file.write("> Total Mutants: "+str(mutantCount)+"\n")
file.write("> Total Killed Mutants: "+str(totalKilled)+"\n")
file.write("> Total Live Mutants: "+str(liveCount)+"\n")
file.write("> Mutation Score: "+str(mutationScore))
file.close()