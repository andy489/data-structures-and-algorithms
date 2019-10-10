## Task 5.

Write a function which checks whether a given string can be rearranged into a palindrome. If it is possible, return **YES**, otherwise return **NO**.

The function has only one parameter

    s: a string to analyze

#### Input Format

A single line which contains **s**, the input string.

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{|s|}\le{10^5}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;|s|"> contains only lowercase letters in the range <img src="https://latex.codecogs.com/svg.latex?\Large&space;ascii[a...z]">

#### Output Format

A single line which contains **YES** or **NO**.

Ecample input | Expected output|Explanation
-|-|-
aaabbbb|YES|A palindromic permutation of the given string is bbaaabb.
cdefghmnopqrstuvw|NO|Palindromes longer than 1 character are made up of pairs of characters. There are none here.
cdcdcdcdeeeef|YES|An example palindrome from the string: ddcceefeeccdd.
