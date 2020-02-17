[Link](https://www.hackerrank.com/challenges/30-data-types/problem)

## Day 1: Data Types

#### Objective
Today, we're discussing data types. Check out the Tutorial tab for learning materials and an instructional video!

#### Task
Complete the code in the editor below. The variables <img src="https://latex.codecogs.com/svg.latex?\Large&space;i,d,"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;s"> are already declared and initialized for you. You must:

1. Declare <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> variables: one of type int, one of type double, and one of type String.
2. Read <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> lines of input from stdin (according to the sequence given in the Input Format section below) and initialize your <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> variables.
3. Use the <img src="https://latex.codecogs.com/svg.latex?\Large&space;+"> operator to perform the following operations:

- 1. Print the sum of <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> plus your int variable on a new line.
- 2. Print the sum of <img src="https://latex.codecogs.com/svg.latex?\Large&space;d"> plus your double variable to a scale of one decimal place on a new line.
- 3. Concatenate <img src="https://latex.codecogs.com/svg.latex?\Large&space;s"> with the string you read as input and print the result on a new line. 

**Note:** If you are using a language that doesn't support using <img src="https://latex.codecogs.com/svg.latex?\Large&space;+"> for string concatenation (e.g.: C), you can just print one variable immediately following the other on the same line. The string provided in your editor must be printed first, immediately followed by the string you read as input.

#### Input Format

- The first line contains an integer that you must sum with <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">.
- The second line contains a double that you must sum with <img src="https://latex.codecogs.com/svg.latex?\Large&space;d">.
- The third line contains a string that you must concatenate with <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">.

#### Output Format

Print the sum of both integers on the first line, the sum of both doubles (scaled to <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> decimal place) on the second line, and then the two concatenated strings on the third line.

#### Sample Input
```
12
4.0
is the best place to learn and practice coding!
```
#### Sample Output
```
16
8.0
HackerRank is the best place to learn and practice coding!
```
#### Explanation

When we sum the integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;12"> , we get the integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;16">.<br>
When we sum the floating-point numbers <img src="https://latex.codecogs.com/svg.latex?\Large&space;4.0"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;4.0">, we get <img src="https://latex.codecogs.com/svg.latex?\Large&space;8.0">.<br>
When we concatenate *HackerRank* with *is the best place to learn and practice coding!*, we get *HackerRank is the best place to learn and practice coding!*.

**You will not pass this challenge if you attempt to assign the Sample Case values to your variables instead of following the instructions above and reading input from stdin.**
