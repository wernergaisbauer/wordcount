# wordcount
https://ccd-school.de/coding-dojo/#cd8

*Note, that in the FileReaderUnitTest there occurs an exception:

java.nio.file.NoSuchFileException: ./src/test/resources/abc.txt

This is because of a test that is intended to fail.

*I believe there is a mistake in the Word Count IX example text:

AsIs:

Enter text: a bb ccc dddd
Number of words: 4, unique: 4; average word length: 2.5 characters

But should be:

Enter text: a bb ccc dddd
Number of words: 3, unique: 3; average word length: 3.0

because a is a stopword.
