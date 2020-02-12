## Longest Path

[Judge System](https://www.hackerrank.com/contests/101hack33/challenges/longest-path)

You are given a tree with <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> nodes. Each node can either be black or white. You need to find the longest path in this tree that consists only of black nodes.<br>
Nodes are numbered from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">.

#### Input Format

The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> the number of nodes. The second line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> integers, representing <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_i"> the colour of node <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">. Here, <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_i"> is <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> for a white node and <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> for a black node.
The next line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N-1"> integers. The <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> integer (<img src="https://latex.codecogs.com/svg.latex?\Large&space;1">-indexed) represents the parent of node <img src="https://latex.codecogs.com/svg.latex?\Large&space;i+1">, which is between <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> is considered the root of the tree. You can assume that the input is a valid tree.

#### Constraints
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}">

#### Output Format

Output the length of the longest path containing only black nodes.

#### Sample Input
```
5   
1 1 0 1 1   
1 2 3 4
```
#### Sample Output
```
2
```
#### Explanation

The given tree is a path <img src="https://latex.codecogs.com/svg.latex?\Large&space;1-2-3-4-5"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> is a white node.<br>
So, the longest path in this tree with only black nodes is of length <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">, which is <img src="https://latex.codecogs.com/svg.latex?\Large&space;1-2"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;4-5">.
