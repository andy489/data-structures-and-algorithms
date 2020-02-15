## Minimum Penalty Path

[Judge System](https://www.hackerrank.com/contests/101hack34/challenges/beautiful-path)

Consider an undirected graph containing <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> nodes and  <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> edges. Each edge <img src="https://latex.codecogs.com/svg.latex?\Large&space;M_i"> has an integer *cost*, <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_i">, associated with it.

The penalty of a path is the [bitwise OR](https://en.wikipedia.org/wiki/Bitwise_operation#OR) of every edge cost in the path between a pair of nodes, <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">. In other words, if a path contains edges <img src="https://latex.codecogs.com/svg.latex?\Large&space;M_1,M_2,...,M_k">, then the penalty for this path is <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_1"> **OR** <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_2"> **OR** ... **OR** <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_k">.

Given a graph and two nodes, <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">, find the path between <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> having the *minimal possible penalty* and print its penalty; if no such path exists, print <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1"> to indicate that there is no path from <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">.

**Note:** Loops and multiple edges are allowed. The bitwise OR operation is known as **or** in Pascal and as **|** in C++ and Java.

#### Input Format

The first line contains two space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">
(the number of nodes) and <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> (the number of edges), respectively.

Each line <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> of the subsequent lines contains three space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;U_i">,<img src="https://latex.codecogs.com/svg.latex?\Large&space;V_1"> , and <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_i">, respectively, describing edge <img src="https://latex.codecogs.com/svg.latex?\Large&space;M_i"> connecting the nodes <img src="https://latex.codecogs.com/svg.latex?\Large&space;U_i"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;V_i"> and its associated penalty (<img src="https://latex.codecogs.com/svg.latex?\Large&space;C_i">).

The last line contains two space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">
(the starting node) and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> (the ending node), respectively.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^3}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{M}\le{10^4}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{C_i}<1024">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{U_i,V_i}\le{N}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{A,B}\le{N}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;A\neq{B}">

#### Output Format

Print the minimal penalty for the optimal path from node <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">; if no path exists from node <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> to node , <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> print <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

#### Sample Input
```
3 4
1 2 1
1 2 1000
2 3 3
1 3 100
1 3
```
#### Sample Output
```
3
```
#### Explanation

The optimal path is <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\rightarrow{2}\rightarrow{3}">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;C_{(1,2)}=1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_{(2,3)}=3">.<br>
The penalty for this path is:**1 OR 3**, so we print **3**.
