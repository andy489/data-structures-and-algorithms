## Minimum Penalty Path

[Judge System](https://www.hackerrank.com/contests/101hack34/challenges/beautiful-path)

Consider an undirected graph containing nodes and edges. Each edge has an integer cost,

, associated with it.

The penalty of a path is the bitwise OR of every edge cost in the path between a pair of nodes,
and . In other words, if a path contains edges , then the penalty for this path is OR OR ... OR

.

Given a graph and two nodes,
and , find the path between and having the minimal possible penalty and print its penalty; if no such path exists, print to indicate that there is no path from to

.

Note: Loops and multiple edges are allowed. The bitwise OR operation is known as or in Pascal and as | in C++ and Java.

Input Format

The first line contains two space-separated integers,
(the number of nodes) and

(the number of edges), respectively.

Each line
of the subsequent lines contains three space-separated integers , , and , respectively, describing edge connecting the nodes and and its associated penalty (

).

The last line contains two space-separated integers,
(the starting node) and

(the ending node), respectively.

Constraints

Output Format

Print the minimal penalty for the optimal path from node
to node ; if no path exists from node to node , print

.

Sample Input

3 4
1 2 1
1 2 1000
2 3 3
1 3 100
1 3

Sample Output

3

Explanation

The optimal path is
.
and .
The penalty for this path is: OR , so we print .
