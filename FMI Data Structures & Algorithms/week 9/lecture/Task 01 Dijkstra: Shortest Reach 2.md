## Dijkstra: Shortest Reach 2

[Judge System](https://www.hackerrank.com/challenges/dijkstrashortreach/problem)

Given an undirected graph and a starting node, determine the lengths of the shortest paths from the starting node to all other nodes in the graph. If a node is unreachable, its distance is -1. Nodes will be numbered consecutively from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, and edges will have varying distances or lengths.

For example, consider the following graph of 5 nodes:
```
Begin	    End	   Weight
1	    2	    5
2	    3	    6
3	    4	    2
1	    3	    15
```

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Dijkstra%2001.png)

Starting at node <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, the shortest path to <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> is direct and distance <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">. Going from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, there are two paths:<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\rightarrow{2}\rightarrow{3}"> at a distance of <img src="https://latex.codecogs.com/svg.latex?\Large&space;5+6=11"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\rightarrow{3}"> at a distance of <img src="https://latex.codecogs.com/svg.latex?\Large&space;15">. Choose the shortest path, <img src="https://latex.codecogs.com/svg.latex?\Large&space;11"> . From <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">, choose the shortest path through <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> and extend it: <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\rightarrow{2}\rightarrow{3}\rightarrow{4}"> for a distance of <img src="https://latex.codecogs.com/svg.latex?\Large&space;11+2=13"> There is no route to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">, so the distance is <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

The distances to all nodes in increasing node order, omitting the starting node, are 5 11 13 -1.

#### Function Description

Complete the shortestReach function in the editor below. It should return an array of integers that represent the shortest distance to each node from the start node in ascending order of node number.

shortestReach has the following parameter(s):

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">: the number of nodes in the graph
- edges: a 2D array of integers where each <img src="https://latex.codecogs.com/svg.latex?\Large&space;edges[i]"> consists of three integers that represent the start and end nodes of an edge, followed by its length
- s: the start node number

#### Input Format

The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;t">, the number of test cases.

Each test case is as follows:<br>
-The first line contains two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;m">, the number of nodes and edges in the graph.<br>
-Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> lines contains three space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;x">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;y"> , and <img src="https://latex.codecogs.com/svg.latex?\Large&space;r">, the beginning and ending nodes of an edge, and the length of the edge.<br>
-The last line of each test case has an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">, denoting the starting position.

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{t}\le{10}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{n}\le{3000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{m}\le{\frac{N\times{N-1}}{2}}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{x,y,s}\le{N}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{r}\le{10^5}">

**If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.**

#### Output Format

For each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;t"> test cases, print a single line consisting <img src="https://latex.codecogs.com/svg.latex?\Large&space;n-1"> space separated integers denoting the shortest distance to the  <img src="https://latex.codecogs.com/svg.latex?\Large&space;n-1"> nodes from starting position <img src="https://latex.codecogs.com/svg.latex?\Large&space;s"> in increasing order of their labels, excluding <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">.

For unreachable nodes, print <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

#### Sample Input
```
1
4 4
1 2 24
1 4 20
3 1 3
4 3 12
1
```
#### Sample Output
```
24 3 15
```
#### Explanation

The graph given in the test case is shown as :

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Dijkstra%2002.png)

* The lines are weighted edges where weight denotes the length of the edge.

The shortest paths followed for the three nodes 2, 3 and 4 are as follows :

**1/S->2** - Shortest Path Value : <img src="https://latex.codecogs.com/svg.latex?\Large&space;24">

**1/S->3** - Shortest Path Value : <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">

**1/S->3->4** - Shortest Path Value : <img src="https://latex.codecogs.com/svg.latex?\Large&space;15">
