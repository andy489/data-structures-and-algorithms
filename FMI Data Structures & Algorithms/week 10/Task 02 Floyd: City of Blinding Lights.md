## Floyd: City of Blinding Lights

[Judge System](https://www.hackerrank.com/contests/practice-9-sda/challenges/floyd-city-of-blinding-lights)

Given a directed weighted graph where weight indicates distance, for each query, determine the length of the shortest path between nodes. There may be many queries, so efficiency counts.

For example, your graph consists of

nodes as in the following:

image

A few queries are from node
to node , node to node , and node to node

.

    There are two paths from 

to

:

at a distance of at a distance of
In this case we choose path

    . 

There is no path from
to , so we return

.

There is one path from
to

:

at a distance of

        . 

Input Format

The first line has two integers
and , the number of nodes and the number of edges in the graph.
Each of the next lines contains three space-separated integers and , the two nodes between which the directed edge exists, and , the length of the edge.
The next line contains a single integer , the number of queries.
Each of the next lines contains two space-separated integers and

, denoting the start and end nodes for traversal.

Constraints






The distance from a node to itself is always

and it is always reachable from itself.

If there are edges between the same pair of nodes with different weights, the last one (most recent) is to be considered as the only edge between them.

Output Format

Print

lines, each containing a single integer specifying the shortest distance for the query.

If the destination node is not reachable, return

.

Sample Input

4 5
1 2 5
1 4 24
2 4 6
3 4 4
3 2 7
3
1 2
3 1
1 4

Sample Output

5
-1
11

Explanation

The graph given in the test case is shown as :

image The shortest paths for the 3 queries are :

: The direct Path is shortest with weight 5

: There is no way of reaching node 1 from node 3

The indirect path is shortest with weight (5+6) = 11 units. The direct path is longer with 24 units length.
