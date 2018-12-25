1. Regular Expressions
1.1. What are regular expressions?

A regular expression defines a search pattern for strings.
The abbreviation for regular expression is regex.
The search pattern can be anything from a simple character, a fixed string or a complex expression containing special characters describing the pattern.
The pattern defined by the regex may match one or several times or not at all for a given string.

Regular expressions can be used to search, edit and manipulate text.

The process of analyzing or modifying a text with a regex is called:
The regular expression is applied to the text/string.
The pattern defined by the regex is applied on the text from left to right.
Once a source character has been used in a match, it cannot be reused.
For example, the regex aba will match ababababa only two times (aba_aba__).


1.2. Regex examples

A simple example for a regular expression is a (literal) string.
For example, the Hello World regex matches the "Hello World" string.
. (dot) is another example for a regular expression.
A dot matches any single character; it would match, for example, "a" or "1".

The following tables lists several regular expressions and describes which pattern they would match.
============================================
Regex				Matches
--------------------------------------------
this is text 		Matches exactly "this is text"
--------------------------------------------
this\s+is\s+text 	Matches the word "this" followed by one or more whitespace characters
					followed by the word "is" followed by one or more whitespace characters followed by the word "text".
--------------------------------------------
^\d+(\.\d+)? 		^ defines that the patter must start at beginning of a new line.
					\d+ matches one or several digits.
					The ? makes the statement in brackets optional.
					\. matches ".", parentheses are used for grouping.
					Matches for example "5", "1.5" and "2.21".
============================================


1.3. Support for regular expressions in programming languages

Regular expressions are supported by most programming languages, e.g., Java, Perl, Groovy, etc.
Unfortunately each language supports regular expressions slightly different.


2. Rules of writing regular expressions
2.1. Common matching symbols

============================================
Regular Expression	Description
--------------------------------------------
.					Matches any character
--------------------------------------------
^regex				Finds regex that must match at the beginning of the line.
--------------------------------------------
regex$				Finds regex that must match at the end of the line.
--------------------------------------------
[abc]				Set definition, can match the letter a or b or c.
--------------------------------------------
[abc][vz]			Set definition, can match a or b or c followed by either v or z.
--------------------------------------------
[^abc]				When a caret appears as the first character inside square brackets,
					it negates the pattern. This pattern matches any character except a or b or c.
--------------------------------------------
[a-d1-7]			Ranges: matches a letter between a and d and figures from 1 to 7, but not d1.
--------------------------------------------
X|Z					Finds X or Z.
--------------------------------------------
XZ					Finds X directly followed by Z.
--------------------------------------------
$					Checks if a line end follows.
============================================

2.2. Meta characters
============================================
Regular Expression		Description
--------------------------------------------
\d						Any digit, short for [0-9]
--------------------------------------------
\D						A non-digit, short for [^0-9]
--------------------------------------------
\s						A whitespace character, short for [ \t\n\x0b\r\f]
--------------------------------------------
\S						A non-whitespace character
--------------------------------------------
\w						A word character, short for [a-zA-Z_0-9]
--------------------------------------------
\W						A non-word character [^\w]
--------------------------------------------
\S+						Several non-whitespace characters
--------------------------------------------
\b						Matches a word boundary where a word character is [a-zA-Z0-9_]
============================================

2.3. Quantifier
============================================
Regular Expression		Description	Examples
--------------------------------------------
*						Occurs zero or more times, is short for {0,}
--------------------------------------------
+						Occurs one or more times, is short for {1,}
--------------------------------------------
?						Occurs no or one times, ? is short for {0,1}.
--------------------------------------------
{X}						Occurs X number of times, {} describes the order of the preceding liberal
--------------------------------------------
{X,Y}					Occurs between X and Y times,
--------------------------------------------
*?						? after a quantifier makes it a reluctant quantifier.
						It tries to find the smallest match.
						This makes the regular expression stop at the first match.
============================================

2.4. Grouping and back reference

You can group parts of your regular expression.
In your pattern you group elements with round brackets, e.g., ().
This allows you to assign a repetition operator to a complete group.

In addition these groups also create a back reference to the part of the regular expression.
This captures the group. A back reference stores the part of the String which matched the group.
This allows you to use this part in the replacement.

Via the $ you can refer to a group. $1 is the first group, $2 the second, etc.

Let’s, for example, assume you want to replace all whitespace between a letter followed by a point or a comma.
This would involve that the point or the comma is part of the pattern. Still it should be included in the result.

// Removes whitespace between a word character and . or ,
String pattern = "(\\w)(\\s+)([\\.,])";
System.out.println(EXAMPLE_TEST.replaceAll(pattern, "$1$3"));

This example extracts the text between a title tag.

// Extract the text between the two title elements
pattern = "(?i)(<title.*?>)(.+?)()";
String updated = EXAMPLE_TEST.replaceAll(pattern, "$2");

2.5. Negative look ahead
Negative look ahead provides the possibility to exclude a pattern.
With this you can say that a string should not be followed by another string.
Negative look ahead are defined via (?!pattern). For example, the following will match "a" if "a" is not followed by "b".
a(?!b)

2.6. Specifying modes inside the regular expression
You can add the mode modifiers to the start of the regex. To specify multiple modes, simply put them together as in (?ismx).
(?i) makes the regex case insensitive.
(?s) for "single line mode" makes the dot match all characters, including line breaks.
(?m) for "multi-line mode" makes the caret and dollar match at the start and end of each line in the subject string.

2.7. Backslashes in Java
The backslash \ is an escape character in Java Strings.
That means backslash has a predefined meaning in Java.
You have to use double backslash \\ to define a single backslash.
If you want to define \w, then you must be using \\w in your regex.
If you want to use backslash as a literal, you have to type \\\\ as \ is also an escape character in regular expressions.


3. Using regular expressions with String methods
3.1. Redefined methods on String for processing regular expressions
Strings in Java have built-in support for regular expressions.
Strings have four built-in methods for regular expressions, i.e.,
the matches(), split()), replaceFirst() and replaceAll() methods.
The replace() method does NOT support regular expressions.


4. Pattern and Matcher
For advanced regular expressions the java.util.regex.Pattern and java.util.regex.Matcher classes are used.
You first create a Pattern object which defines the regular expression.
This Pattern object allows you to create a Matcher object for a given string.
This Matcher object then allows you to do regex operations on a String.













