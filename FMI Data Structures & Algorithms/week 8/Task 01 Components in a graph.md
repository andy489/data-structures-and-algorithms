## Components in a Graph

[Judge System for the Task](https://www.hackerrank.com/contests/sda-hw-10/challenges/components-in-graph/problem)

There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;2N"> values to represent nodes in a graph. They are divided into two sets <img src="https://latex.codecogs.com/svg.latex?\Large&space;G"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">. Each set has exactly <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> values. Set <img src="https://latex.codecogs.com/svg.latex?\Large&space;G"> is represent by <img src="https://latex.codecogs.com/svg.latex?\Large&space;\{G_1,G_2,...,G_N\}">. <img src="https://latex.codecogs.com/svg.latex?\Large&space;G"> can contain any value between <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">(inclusive). Set <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> is represented by <img src="https://latex.codecogs.com/svg.latex?\Large&space;\{B_1,B_2,...,B_N\}">.<img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> can contain any value between <img src="https://latex.codecogs.com/svg.latex?\Large&space;N+1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;2N">(inclusive). Same value can be chosen any number of times.

Here <img src="https://latex.codecogs.com/svg.latex?\Large&space;(G_1,B_1),(G_2,B_2),...,(G_N,B_N)"> represents the edges of the graph.

Your task is to print the number of vertices in the smallest and the largest connected components of the graph.

**Note** Single nodes should not be considered in the answer.

For more clarity look at the following figure.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Components%20in%20a%20Graph%2001.png)

For the above graph smallest connected component is 4 and largest connected component is 22.

#### Input Format

First line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">.
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> lines contain two space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;G_i"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_i">.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{1500}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{G_i}\le{N}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;N+1\le{B_i}\le{2N}">

#### Output Format

Print two space separated integers, the number of vertices in the smallest and the largest components.

Sample Input|Sample Output|Explanation
-|-|-
5<br>1 6<br>2 7<br>3 8<br>4 9<br>2 6|2 4|The number of vertices in the smallest connected component in the graph is <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> i.e. either <img src="https://latex.codecogs.com/svg.latex?\Large&space;(3,8)"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;(4,9)">. The number of vertices in the largest connected component in the graph is <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> i.e. <img src="https://latex.codecogs.com/svg.latex?\Large&space;1-2-6-7"> . 
