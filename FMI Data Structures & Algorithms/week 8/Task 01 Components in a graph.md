## Components in a Graph

[Judge System](https://www.hackerrank.com/contests/sda-hw-10/challenges/components-in-graph/problem)

There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;2N"> values to represent nodes in a graph. They are divided into two sets <img src="https://latex.codecogs.com/svg.latex?\Large&space;G"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">. Each set has exactly <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> values. Set <img src="https://latex.codecogs.com/svg.latex?\Large&space;G"> is represent by <img src="https://latex.codecogs.com/svg.latex?\Large&space;\{B_1,B_2,...,B_N\}">.<img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> can contain any value between <img src="https://latex.codecogs.com/svg.latex?\Large&space;N+1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;2N">(inclusive). Set is represented by . can contain any value between to

(inclusive). Same value can be chosen any number of times.

Here

represents the edges of the graph.

Your task is to print the number of vertices in the smallest and the largest connected components of the graph.

Note Single nodes should not be considered in the answer.

For more clarity look at the following figure.

Alt text

For the above graph smallest connected component is 7 and largest connected component is 17.

Input Format

First line contains an integer
.
Each of the next lines contain two space-separated integers, line contains and

.

Constraints

Output Format

Print two space separated integers, the number of vertices in the smallest and the largest components.

Sample Input

5
1 6 
2 7
3 8
4 9
2 6

Sample Output

2 4

Explanation

The number of vertices in the smallest connected component in the graph is
i.e. either or .
The number of vertices in the largest connected component in the graph is i.e. . 
