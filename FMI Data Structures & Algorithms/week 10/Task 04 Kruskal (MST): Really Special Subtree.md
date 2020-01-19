#### Kruskal (MST): Really Special Subtree

[Judge System](https://www.hackerrank.com/contests/practice-9-sda/challenges/kruskalmstrsub)

Given an undirected weighted connected graph, find the Really Special SubTree in it. The Really Special SubTree is defined as a subgraph consisting of all the nodes in the graph and:

- There is only one exclusive path from a node to every other node.
- The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs.
- No cycles are formed.

To create the Really Special SubTree, always pick the edge with smallest weight. Determine if including it will create a cycle. If so, ignore the edge. If there are edges of equal weight available:

- Choose the edge that minimizes the sum <img src="https://latex.codecogs.com/svg.latex?\Large&space;u+v+wt"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;u"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v"> are vertices and <img src="https://latex.codecogs.com/svg.latex?\Large&space;wt"> is the edge weight.
- If there is still a collision, choose any of them.

Print the overall weight of the tree formed using the rules.

For example, given the following edges:
```
u	v	wt
1	2	2
2	3	3
3	1	5
```
First choose <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\rightarrow{2}"> at weight <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">. Next choose <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\rightarrow{3}"> at weight <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">. All nodes are connected without cycles for a total weight of <img src="https://latex.codecogs.com/svg.latex?\Large&space;3+2=5">.

#### Function Description

Complete the <img src="https://latex.codecogs.com/svg.latex?\Large&space;kruskals"> function in the editor below. It should return an integer that represents the total weight of the subtree formed.

kruskals has the following parameters:

- g_nodes: an integer that represents the number of nodes in the tree
- g_from: an array of integers that represent beginning edge node numbers
- g_to: an array of integers that represent ending edge node numbers
- g_weight: an array of integers that represent the weights of each edge

#### Input Format

The first line has two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;g_nodes"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;g_edges">, the number of nodes and edges in the graph.

The next <img src="https://latex.codecogs.com/svg.latex?\Large&space;g_edges"> lines each consist of three space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;g_from">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;g_to"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;g_weight">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;g_from"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;g_to"> denote the two nodes between which the **undirected** edge exists and <img src="https://latex.codecogs.com/svg.latex?\Large&space;g_weight"> denotes the weight of that edge.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{g_nodes}\le{3000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{g_edges\le{\frac{N(N-1)}{2}}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{g_from,g_to}\le{N}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{g_weight}\le{10^5}">

**Note:** If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.

#### Output Format

Print a single integer denoting the total weight of the Really Special SubTree.
