## Task 6.

Steve has a string of lowercase characters in range <img src="https://latex.codecogs.com/svg.latex?\Large&space;ascii[‘a’..’z’]">. He wants to reduce the string to its shortest length by doing a series of operations. In each operation he selects a pair of adjacent lowercase letters that match, and he deletes them. For instance, the string **aab** could be shortened to **b** in one operation.

Steve’s task is to delete as many characters as possible using this method and print the resulting string. If the final string is empty, print **Empty String**

#### Function Description

Write a *superReducedString* function. It should return the super reduced string or *Empty String* if the final string is empty.

*superReducedString* has the following parameter(s):

    s: a string to reduce

#### Input Format

A single string, **s**.

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{|s|}\le{100}">

#### Output Format

If the final string is empty, print **Empty String**; otherwise, print the final non-reducible string.

Wxample input|Expected output|Explanation
-|-|-
aaabccddd|abd|Steve performs the following sequence of operations to get the final string:<br>aaabccddd → abccddd → abddd → abd
aa|Empty String|aa → Empty String
baab|Empty String|baab → bb → Empty String
