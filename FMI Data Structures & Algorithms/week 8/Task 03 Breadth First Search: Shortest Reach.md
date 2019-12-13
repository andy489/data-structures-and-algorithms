## Breadth First Search: Shortest Reach

[Judge System](https://www.hackerrank.com/challenges/bfsshortreach/problem)

Consider an undirected graph where each edge is the same weight. Each of the nodes is labeled consecutively.

You will be given a number of queries. For each query, you will be given a list of edges describing an undirected graph. After you create a representation of the graph, you must determine and report the shortest distance to each of the other nodes from a given starting position using the breadth-first search algorithm (BFS). Distances are to be reported in node number order, ascending. If a node is unreachable, print

for that node. Each of the edges weighs 6 units of distance.

For example, given a graph with
nodes and edges,

, a visual representation is:

image

The start node for the example is node
. Outputs are calculated for distances to nodes through : . Each edge is units, and the unreachable node has the required return distance of

.

Function Description

Complete the bfs function in the editor below. It must return an array of integers representing distances from the start node to each other node in node ascending order. If a node is unreachable, its distance is

.

bfs has the following parameter(s):

    n: the integer number of nodes
    m: the integer number of edges
    edges: a 2D array of start and end nodes for edges
    s: the node to start traversals from

Input Format

The first line contains an integer
, the number of queries. Each of the following

sets of lines has the following format:

    The first line contains two space-separated integers 

and
, the number of nodes and edges in the graph.
Each line
of the subsequent lines contains two space-separated integers, and , describing an edge connecting node to node
.
The last line contains a single integer,

    , denoting the index of the starting node.

Constraints

Output Format

For each of the
queries, print a single line of space-separated integers denoting the shortest distances to each of the other nodes from starting position . These distances should be listed sequentially by node number (i.e., ), but should not include node . If some node is unreachable from , print

as the distance to that node.

Sample Input

2
4 2
1 2
1 3
1
3 1
2 3
2

Sample Output

6 6 -1
-1 6

Explanation

We perform the following two queries:

    The given graph can be represented as:
    image
    where our start node, 

, is node . The shortest distances from to the other nodes are one edge to node , one edge to node , and an infinite distance to node (which it's not connected to). We then print node 's distance to nodes , , and

(respectively) as a single line of space-separated integers: 6, 6, -1.

The given graph can be represented as:
image
where our start node,
, is node . There is only one edge here, so node is unreachable from node and node has one edge connecting it to node . We then print node 's distance to nodes and

    (respectively) as a single line of space-separated integers: -1 6.

Note: Recall that the actual length of each edge is
, and we print as the distance to any node that's unreachable from .
