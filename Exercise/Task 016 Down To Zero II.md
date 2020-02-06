## Down To Zero II

[Judge System](https://www.hackerrank.com/challenges/down-to-zero-ii/problem?h_r=internal-search)

You are given <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> queries. Each query consists of a single number <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">. You can perform any of the operations on <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> in each move:

1: If we take 2 integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;b"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;N=a\times{b}(a\neq{1},b\neq{1})">, then we can change <img src="https://latex.codecogs.com/svg.latex?\Large&space;N=max\{a,b\}"> 

2: Decrease the value of <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> by 1.

Determine the minimum number of moves required to reduce the value of <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;0">.

#### Input Format

The first line contains the integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q">.
The next <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> lines each contain an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">.

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Q}\le{10^3}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{N}\le{10^6}">

#### Output Format

Output <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> lines. Each line containing the minimum number of moves required to reduce the value of <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;0">.

#### Sample Input
```
2
3
4
```
#### Sample Output
```
3
3
```
#### Explanation

For test case 1, We only have one option that gives the minimum number of moves.

Follow
<img src="https://latex.codecogs.com/svg.latex?\Large&space;3\rightarrow{2}\rightarrow{1}\rightarrow{0}">. Hence, <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> moves.

For the case 2, we can either go <img src="https://latex.codecogs.com/svg.latex?\Large&space;4\rightarrow{3}\rightarrow{2}\rightarrow{1}\rightarrow{0}"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;4\rightarrow{2}\rightarrow{1}\rightarrow{0}">. The 2nd option is more optimal. Hence, <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> moves.
