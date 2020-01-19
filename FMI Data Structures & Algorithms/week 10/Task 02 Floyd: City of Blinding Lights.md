## Floyd : City of Blinding Lights

[Judge System](https://www.hackerrank.com/contests/practice-9-sda/challenges/floyd-city-of-blinding-lights)

Given a directed weighted graph where weight indicates distance, for each query, determine the length of the shortest path between nodes. There may be many queries, so efficiency counts.

For example, your graph consists of <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> nodes as in the following:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Floyd%20-%20City%20of%20Blinding%20Lights%2001.png)

A few queries are from node <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, node <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">, and node <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">.

1. There are two paths from <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">:

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;4\Rightarrow{1}\Rightarrow{2}\Rightarrow{3}"> at a distance of <img src="https://latex.codecogs.com/svg.latex?\Large&space;4+5+1=10">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;4\Rightarrow{1}\Rightarrow{5}\Rightarrow{3}"> at a distance of <img src="https://latex.codecogs.com/svg.latex?\Large&space;4+3+2=9"><br>
In this case we choose path <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">. 

2. There is no path from <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">, so we return <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

3. There is one path from <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">:

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;5\Rightarrow{3}"> at a distance of <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">. 

#### Input Format

The first line has two integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;m">, the number of nodes and the number of edges in the graph.
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> lines contains three space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;x,y"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;r">, the two nodes between which the *directed* edge <img src="https://latex.codecogs.com/svg.latex?\Large&space;x\Rightarrow{y}"> exists, and <img src="https://latex.codecogs.com/svg.latex?\Large&space;r">, the length of the edge.<br>
The next line contains a single integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;q">, the number of queries.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> lines contains two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;b">, denoting the start and end nodes for traversal.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{n}\le{400}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{m\le{\frac{n\times{(n-1)}}{2}}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{q}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{x,y}\le{N}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{r}\le{350}">

The distance from a node to itself is always <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> and it is always reachable from itself.

**If there are edges between the same pair of nodes with different weights, the last one (most recent) is to be considered as the only edge between them.**

#### Output Format

Print <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> lines, each containing a single integer specifying the shortest distance for the query.

If the destination node is not reachable, return <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

Sample Input|Sample Output
-|-
4 5<br>1 2 5<br>1 4 24<br>2 4 6<br>3 4 4<br>3 2 7<br>3<br>1 2<br>3 1<br>1 4|5<br>-1<br>11

**Explanation**

The graph given in the test case is shown as :

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Floyd%20-%20City%20of%20Blinding%20Lights%2002.png)

The shortest paths for the <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> queries are :

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\Rightarrow{2}">: The direct Path is shortest with weight <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">: There is no way of reaching node <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> from node <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\Rightarrow{2}\Rightarrow{4}"> The indirect path is shortest with weight <img src="https://latex.codecogs.com/svg.latex?\Large&space;(5+6)=11"> units. The direct path is longer with <img src="https://latex.codecogs.com/svg.latex?\Large&space;24"> units length.
