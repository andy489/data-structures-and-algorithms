## Forming a Magic Square

[Judge System](https://www.hackerrank.com/challenges/magic-square-forming/problem)

We define a [magic square]() to be an <img src="https://latex.codecogs.com/svg.latex?\Large&space;n\times{n}"> matrix of distinct positive integers from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^2"> where the sum of any row, column, or diagonal of length <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is always equal to the same number: the magic constant.

You will be given a <img src="https://latex.codecogs.com/svg.latex?\Large&space;3\times{3}"> matrix <img src="https://latex.codecogs.com/svg.latex?\Large&space;s"> of integers in the inclusive range <img src="https://latex.codecogs.com/svg.latex?\Large&space;[1,9]">. We can convert any digit <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> to any other digit <img src="https://latex.codecogs.com/svg.latex?\Large&space;b"> in the range <img src="https://latex.codecogs.com/svg.latex?\Large&space;[1,9]"> at cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;|a-b|">. Given <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">, convert it into a magic square at minimal cost. Print this cost on a new line.

**Note:** The resulting magic square must contain distinct integers in the inclusive range <img src="https://latex.codecogs.com/svg.latex?\Large&space;[1,9]">.

For example, we start with the following matrix <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">:
```
5 3 4
1 5 8
6 4 2
```
We can convert it to the following magic square:
```
8 3 4
1 5 9
6 7 2
```
This took three replacements at a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;|5-8|+|8-9|+|4-7|=7.">.

#### Function Description

Complete the formingMagicSquare function in the editor below. It should return an integer that represents the minimal total cost of converting the input square to a magic square.

formingMagicSquare has the following parameter(s):

- s: a <img src="https://latex.codecogs.com/svg.latex?\Large&space;3\times{3}"> array of integers

#### Input Format

Each of the lines contains three space-separated integers of row <img src="https://latex.codecogs.com/svg.latex?\Large&space;s[i]">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;s[i][j]\in{[1,9]}">
#### Output Format

Print an integer denoting the minimum cost of turning matrix <img src="https://latex.codecogs.com/svg.latex?\Large&space;s"> into a magic square.

#### Sample Input 0
```
4 9 2
3 5 7
8 1 5
```
#### Sample Output 0
```
1
```
#### Explanation 0

If we change the bottom right value, <img src="https://latex.codecogs.com/svg.latex?\Large&space;s[2][2]">, from <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> at a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;|6-5|=1">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;s"> becomes a magic square at the minimum possible cost.

#### Sample Input 1
```
4 8 2
4 5 7
6 1 6
```
#### Sample Output 1
```
4
```
#### Explanation 1

Using 0-based indexing, if we make

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;s[0][1]\rightarrow{9}"> at a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;|9-8|=1">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;s[1][0]\rightarrow{3}"> at a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;|3-4|=1">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;s[2][0]\rightarrow{8}"> at a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;|8-6|=2">,

then the total cost will be <img src="https://latex.codecogs.com/svg.latex?\Large&space;1+1+2=4">.
