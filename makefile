all: target1 target2
	echo "All done"

target1:
	MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

target2:
	MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class 	
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

