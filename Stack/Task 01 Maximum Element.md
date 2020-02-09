## Maximum Element

[Judge System](https://www.hackerrank.com/challenges/maximum-element/problem)

You have an empty sequence, and you will be given <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> queries. Each query is one of these three types:
```
1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.
```
#### Input Format

The first line of input contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">. The next <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> lines each contain an above mentioned query. *(It is guaranteed that each query is valid.)*

#### Constraints
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{x}\le{10^9}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{type\le{3}}">

#### Output Format

For each type <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> query, print the maximum element in the stack on a new line.

#### Sample Input
```
10
1 97
2
1 20
2
1 26
1 20
2
3
1 91
3
```
#### Sample Output
```
26
91
```
