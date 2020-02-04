## Components in a Graph

[Judge System](https://www.hackerrank.com/challenges/components-in-graph/problem)

There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;2N"> values to represent nodes in a graph. They are divided into two sets <img src="https://latex.codecogs.com/svg.latex?\Large&space;G"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">. Each set has exactly <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> values. Set <img src="https://latex.codecogs.com/svg.latex?\Large&space;G"> is represent by <img src="https://latex.codecogs.com/svg.latex?\Large&space;\{G_1,G_2,...,G_N\}">. <img src="https://latex.codecogs.com/svg.latex?\Large&space;G"> can contain any value between <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> (inclusive). Set <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> is represented by <img src="https://latex.codecogs.com/svg.latex?\Large&space;\{B_1,B_2,...,B_N\}">. <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> can contain any value between <img src="https://latex.codecogs.com/svg.latex?\Large&space;N+1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;2N">(inclusive). Same value can be chosen any number of times.

Here <img src="https://latex.codecogs.com/svg.latex?\Large&space;(G_1,B_1),(G_2,B_2),...,(G_N,B_N)"> represents the edges of the graph.

Your task is to print the number of vertices in the smallest and the largest connected components of the graph.

**Note** Single nodes should not be considered in the answer.

#### Input Format

First line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> lines contain two space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;G_i"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_i">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{15000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{G_i}\le{N}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;N+1\le{B_i}\le{2N}">
#### Output Format

Print two space separated integers, the number of vertices in the smallest and the largest components.

#### Sample Input
```
5
1 6 
2 7
3 8
4 9
2 6
```
#### Sample Output
```
2 4
```
#### Explanation

The number of vertices in the smallest connected component in the graph is <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> i.e. either <img src="https://latex.codecogs.com/svg.latex?\Large&space;(3,9)"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;4,9)">.<br>
The number of vertices in the largest connected component in the graph is <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> i.e. <img src="https://latex.codecogs.com/svg.latex?\Large&space;1-6-2-7">. 
