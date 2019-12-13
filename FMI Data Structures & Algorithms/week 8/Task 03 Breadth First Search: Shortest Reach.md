## Breadth First Search: Shortest Reach

[Judge System](https://www.hackerrank.com/challenges/bfsshortreach/problem)

Consider an undirected graph where each edge is the same weight. Each of the nodes is labeled consecutively.

You will be given a number of queries. For each query, you will be given a list of edges describing an undirected graph. After you create a representation of the graph, you must determine and report the shortest distance to each of the other nodes from a given starting position using the breadth-first search algorithm ([BFS](https://en.wikipedia.org/wiki/Breadth-first_search)). Distances are to be reported in node number order, ascending. If a node is unreachable, print <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1"> for that node. Each of the edges weighs 6 units of distance.

For example, given a graph with <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> nodes and <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> edges, <img src="https://latex.codecogs.com/svg.latex?\Large&space;[1,2],[1,3],[3,4]">, a visual representation is:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Breadth%20First%20Search%20-%20Shortest%20Reach%2001.png)

The start node for the example is node <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">. Outputs are calculated for distances to nodes <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> through <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">: <img src="https://latex.codecogs.com/svg.latex?\Large&space;[6,6,12,-1]"> . Each edge is <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> units, and the unreachable node <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> has the required return distance of <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

#### Function Description

Complete the bfs function in the editor below. It must return an array of integers representing distances from the start node to each other node in node ascending order. If a node is unreachable, its distance is <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

bfs has the following parameter(s):

- n: the integer number of nodes
- m: the integer number of edges
- edges: a 2D array of start and end nodes for edges
- s: the node to start traversals from

#### Input Format

The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;q">, the number of queries. Each of the following <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> sets of lines has the following format:
<img src="https://latex.codecogs.com/svg.latex?\Large&space;3">

- The first line contains two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> the number of nodes and edges in the graph.
- Each line <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> subsequent lines contains two space-separated integers,<img src="https://latex.codecogs.com/svg.latex?\Large&space;u"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v">, describing an edge connecting node <img src="https://latex.codecogs.com/svg.latex?\Large&space;u"> to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;v">.
- The last line contains a single integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">, denoting the index of the starting node.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{q}\le{10}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{n}\le{1000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{m}\le{\frac{n(n-1)}{2}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{u,v,s}\le{n}">

#### Output Format

For each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> queries, print a single line of  <img src="https://latex.codecogs.com/svg.latex?\Large&space;n-1"> space-separated integers denoting the shortest distances to each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;n-1"> other nodes from starting position <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">. These distances should be listed sequentially by node number (i.e., <img src="https://latex.codecogs.com/svg.latex?\Large&space;1,2,...,n">), but should not include node <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">. If some node is unreachable from <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">, print <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1"> as the distance to that node.

Sample Input|Sample Output
-|-
2<br>4 2<br>1 2<br>1 3<br>1<br>3 1<br>2 3<br>2|6 6 -1<br>-1 6

#### Explanation

We perform the following two queries:

- 1. The given graph can be represented as:
   
   ![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Breadth%20First%20Search%20-%20Shortest%20Reach%2002.png)
   
where our start node, <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">, is node <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">. The shortest distances from <img src="https://latex.codecogs.com/svg.latex?\Large&space;s"> to the other nodes are one edge to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">, one edge to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, and an infinite distance to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">(which it's not connected to). We then print node <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">'s distance to nodes <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">,<img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, and <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">(respectively) as a single line of space-separated integers: 6, 6, -1.

- 2. The given graph can be represented as:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Breadth%20First%20Search%20-%20Shortest%20Reach%2003.png)

where our start node,<img src="https://latex.codecogs.com/svg.latex?\Large&space;s">, is node <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">. There is only one edge here, so node <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> is unreachable from node <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> and node <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> has one edge connecting it to node <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">. We then print node <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">'s distance to nodes and <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">(respectively) as a single line of space-separated integers: -1 6.

**Note:** Recall that the actual length of each edge is <img src="https://latex.codecogs.com/svg.latex?\Large&space;6">, and we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1"> as the distance to any node that's unreachable from <img src="https://latex.codecogs.com/svg.latex?\Large&space;s">.
