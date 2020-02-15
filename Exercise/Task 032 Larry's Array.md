## Larry's Array

[Judge System](https://www.hackerrank.com/challenges/larrys-array/problem)

Larry has been given a permutation of a sequence of natural numbers incrementing from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> as an array. He must determine whether the array can be sorted using the following operation any number of times:

- Choose any <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> consecutive indices and rotate their elements in such a way that <img src="https://latex.codecogs.com/svg.latex?\Large&space;ABC\rightarrow{BCA}\rightarrow{CAB}\rightarrow{ABC}">.

For example, if <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=\{1,6,5,2,4,3\}">:
```
A		rotate 
[1,6,5,2,4,3]	[6,5,2]
[1,5,2,6,4,3]	[5,2,6]
[1,2,6,5,4,3]	[5,4,3]
[1,2,6,3,5,4]	[6,3,5]
[1,2,3,5,6,4]	[5,6,4]
[1,2,3,4,5,6]

YES
```
On a new line for each test case, print *YES* if <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> can be fully sorted. Otherwise, print *NO*.

#### unction Description

Complete the larrysArray function in the editor below. It must return a string, either *YES* or *NO*.

larrysArray has the following parameter(s):
- A: an array of integers

#### Input Format

The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;t">, the number of test cases.

The next <img src="https://latex.codecogs.com/svg.latex?\Large&space;t"> pairs of lines are as follows:

- The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the length of <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">.
- The next line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;A[i]">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{t}\le{10}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;3\le{n}\le{1000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{A[i]}\le{1000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_{sorted}="> integers that increment by <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">

#### Output Format

For each test case, print *YES* if <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> can be fully sorted. Otherwise, print *NO*.

#### Sample Input
```
3
3
3 1 2
4
1 3 4 2
5
1 2 3 5 4
```
#### Sample Output
```
YES
YES
NO
```
#### Explanation

In the explanation below, the subscript of <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> denotes the number of operations performed.

Test Case 0:<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_0=\{3,1,2\}\rightarrow{rotate}(3,1,2)\rightarrow{A_1=\{1,2,3\}}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> is now sorted, so we print *YES* on a new line.

Test Case 1:<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_0=\{1,3,4,2\}\rightarrow{rotate}(3,4,2)\rightarrow{A_1=\{1,4,2,3\}}">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_1=\{1,4,2,3\}\rightarrow{rotate}(4,2,3)\rightarrow{A_2=\{1,2,3,4\}}">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> is now sorted, so we print *YES* on a new line.

Test Case 2:
No sequence of rotations will result in a sorted <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">. Thus, we print *NO* on a new line.
