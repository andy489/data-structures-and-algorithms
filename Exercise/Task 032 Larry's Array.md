## Larry's Array

[Judge System](https://www.hackerrank.com/challenges/larrys-array/problem)

Larry has been given a permutation of a sequence of natural numbers incrementing from

as an array. He must determine whether the array can be sorted using the following operation any number of times:

    Choose any 

consecutive indices and rotate their elements in such a way that

    .

For example, if

:

A		rotate 
[1,6,5,2,4,3]	[6,5,2]
[1,5,2,6,4,3]	[5,2,6]
[1,2,6,5,4,3]	[5,4,3]
[1,2,6,3,5,4]	[6,3,5]
[1,2,3,5,6,4]	[5,6,4]
[1,2,3,4,5,6]

YES

On a new line for each test case, print YES if

can be fully sorted. Otherwise, print NO.

Function Description

Complete the larrysArray function in the editor below. It must return a string, either YES or NO.

larrysArray has the following parameter(s):

    A: an array of integers

Input Format

The first line contains an integer

, the number of test cases.

The next

pairs of lines are as follows:

    The first line contains an integer 

, the length of
.
The next line contains
space-separated integers

    .

Constraints

integers that increment by from to

Output Format

For each test case, print YES if

can be fully sorted. Otherwise, print NO.

Sample Input

3
3
3 1 2
4
1 3 4 2
5
1 2 3 5 4

Sample Output

YES
YES
NO

Explanation

In the explanation below, the subscript of

denotes the number of operations performed.

Test Case 0:

is now sorted, so we print

on a new line.

Test Case 1:
.
.
is now sorted, so we print

on a new line.

Test Case 2:
No sequence of rotations will result in a sorted
. Thus, we print on a new line
