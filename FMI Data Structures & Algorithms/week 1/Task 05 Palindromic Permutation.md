Complete the gameOfThrones function below to determine whether a given string can be rearranged into a palindrome. If it is possible, return YES, otherwise return NO.

gameOfThrones has the following parameter(s):

    s: a string to analyze

Input Format

A single line which contains

, the input string.

Constraints

|s| contains only lowercase letters in the range

Output Format

A single line which contains YES or NO.

Sample Input 0

aaabbbb

Sample Output 0

YES

Explanation 0

A palindromic permutation of the given string is bbaaabb.

Sample Input 1

cdefghmnopqrstuvw

Sample Output 1

NO

Explanation 1

Palindromes longer than 1 character are made up of pairs of characters. There are none here.

Sample Input 2

cdcdcdcdeeeef

Sample Output 2

YES

Explanation 2

An example palindrome from the string: ddcceefeeccdd.
