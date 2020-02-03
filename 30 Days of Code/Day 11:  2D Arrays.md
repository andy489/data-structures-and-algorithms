https://www.hackerrank.com/challenges/30-2d-arrays/problem

## Day 11: 2D Arrays

#### Objective
Today, we're building on our knowledge of Arrays by adding another dimension. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-2d-arrays/tutorial) tab for learning materials and an instructional video!

#### Context
Given a <img src="https://latex.codecogs.com/svg.latex?\Large&space;6\times{6}"> 2D Array, <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">:
```
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
```
We define an hourglass in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> to be a subset of values with indices falling in this pattern in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">'s graphical representation:
```
a b c
  d
e f g
```
There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;16"> hourglasses in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">, and an hourglass sum is the sum of an hourglass' values.

#### Task
Calculate the hourglass sum for every hourglass in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">, then print the maximum hourglass sum.

#### Input Format

There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> lines of input, where each line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;inputStrin6g"> space-separated integers describing 2D Array <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">; every value in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> will be in the inclusive range of <img src="https://latex.codecogs.com/svg.latex?\Large&space;-9"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;9">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;-9\le{A[i][j]}\le{9}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{i,j}\le{5}">
#### Output Format

Print the largest (maximum) hourglass sum found in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">.

#### Sample Input
```
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
```
#### Sample Output
```
19
```
#### Explanation

<img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> contains the following hourglasses:
```
1 1 1   1 1 0   1 0 0   0 0 0
  1       0       0       0
1 1 1   1 1 0   1 0 0   0 0 0

0 1 0   1 0 0   0 0 0   0 0 0
  1       1       0       0
0 0 2   0 2 4   2 4 4   4 4 0

1 1 1   1 1 0   1 0 0   0 0 0
  0       2       4       4
0 0 0   0 0 2   0 2 0   2 0 0

0 0 2   0 2 4   2 4 4   4 4 0
  0       0       2       0
0 0 1   0 1 2   1 2 4   2 4 0
```
The hourglass with the maximum sum (<img src="https://latex.codecogs.com/svg.latex?\Large&space;19">) is:
```
2 4 4
  2
1 2 4
```
