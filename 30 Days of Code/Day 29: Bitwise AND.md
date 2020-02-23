[Link](https://www.hackerrank.com/challenges/30-bitwise-and/problem)

## Day 29: Bitwise AND

#### Objective
Welcome to the last day! Today, we're discussing bitwise operations. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-bitwise-and/tutorial) tab for learning materials and an instructional video!

#### Task
Given set <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=\{1,2,3,...,N\}">. Find two integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> (where <img src="https://latex.codecogs.com/svg.latex?\Large&space;A<B">), from set <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> such that the value of <img src="https://latex.codecogs.com/svg.latex?\Large&space;A&B"> is the maximum possible and also less than a given integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;K">. In this case, <img src="https://latex.codecogs.com/svg.latex?\Large&space;&"> represents the bitwise AND operator.

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;T">, the number of test cases.<br>
Each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> subsequent lines defines a test case as <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;K">, respectively.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{T}\le{10^3}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{N}\le{10^3}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{K\le{N}}">

#### Output Format

For each test case, print the maximum possible value of <img src="https://latex.codecogs.com/svg.latex?\Large&space;A&B"> on a new line.

#### Sample Input
```
3
5 2
8 5
2 2
```
#### Sample Output
```
1
4
0
```
#### Explanation
<img src="https://latex.codecogs.com/svg.latex?\Large&space;N=5,K=2,S=\{\1,2,3,4,5}"><br>
All possible values of <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> are:<br>

1. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=1,B=2;A&B=0"><br>
2. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=1,B=3;A&B=1"><br>
3. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=1,B=4;A&B=0"><br>
4. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=1,B=5;A&B=1"><br>
5. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=2,B=3;A&B=2"><br>
6. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=2,B=4;A&B=0"><br>
7. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=2,B=5;A&B=0"><br>
8. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=3,B=4;A&B=0"><br>
9. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=3,B=4;A&B=1"><br>
10. <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=4,B=5;A&B=4"><br>

The maximum possible value of <img src="https://latex.codecogs.com/svg.latex?\Large&space;A&B"> that is also <img src="https://latex.codecogs.com/svg.latex?\Large&space;<(K=2)"> is <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, so we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> on a new line.
