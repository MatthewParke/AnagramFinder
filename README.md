# AnagramFinder
A program made for my algorithms analysis class that is able to find all anagrams for every word in a dictionary.
I have included a pdf of the analysis for the program which touches on descriptions, correctness proof, runtimes, and runtime analysis

If you need to run the program:
The main is in Anagrams.java, so run via that class.
I take input files in through the args[], only 1 input at a time.
My project is a package so the .class files will end up in a folder called "anagrams".
For smaller inputs, such as dict1, "java -cp . anagrams.Anagrams dict1" is what I used to run
	through the command line on windows.
For larger inputs, such as dict2, "java -Xmx1024m -cp . anagrams.Anagrams dict2" is what I 
	used to run through the command line on windows.
	The -Xmx1024m is used to allocate extra memory to the JVM at runtime, 1024m being 1024 megabytes.
