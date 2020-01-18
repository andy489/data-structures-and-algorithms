## Organizing Containers of Balls

[Judge System](https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem)

David has several containers, each with a number of balls in it. He has just enough containers to sort each type of ball he has into its own container. David wants to sort the balls using his sort method.

As an example, David has <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=2"> containers and different types of balls, both of which are numbered from <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;n-1=1">. The distribution of ball types per container are described by an <img src="https://latex.codecogs.com/svg.latex?\Large&space;n\times{n}"> matrix of integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;M[container][type]">. For example, consider the following diagram for <img src="https://latex.codecogs.com/svg.latex?\Large&space;M=[[1,4],[2,3]]">:

![]()

In a single operation, David can swap two balls located in different containers.

The diagram below depicts a single swap operation:

![]()

David wants to perform some number of swap operations such that:

- Each container contains only balls of the same type.
- No two balls of the same type are located in different containers.

You must perform <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> queries where each query is in the form of a matrix, <img src="https://latex.codecogs.com/svg.latex?\Large&space;M">. For each query, print *Possible* on a new line if David can satisfy the conditions above for the given matrix. Otherwise, print *Impossible*.

#### Input Format

The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;q">, the number of queries.

Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> sets of lines is as follows:

- 1. The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the number of containers (rows) and ball types (columns).
- 2. Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> lines contains space-separated integers describing row <img src="https://latex.codecogs.com/svg.latex?\Large&space;M[i]">.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{q}\le{10}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{100}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{M[container][type]\le{10^9}}">

Scoring
- For <img src="https://latex.codecogs.com/svg.latex?\Large&space;33%"> of score, <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10}">.
- For <img src="https://latex.codecogs.com/svg.latex?\Large&space;100%"> of score, <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{100}">.

#### Output Format

For each query, print *Possible* on a new line if David can satisfy the conditions above for the given matrix. Otherwise, print *Impossible*.

Sample Input 0|Sample Output 0
-|-
2<br>2<br>1 1<br>1 1<br>2<br>0 2<br>1 1|Possible<br>Impossible

**Explanation 0**

We perform the following <img src="https://latex.codecogs.com/svg.latex?\Large&space;q=2"> queries:

1. The diagram below depicts one possible way to satisfy David's requirements for the first query: 

![]()
Thus, we print Possible on a new line.

2. The diagram below depicts the matrix for the second query: 

![]() 

No matter how many times we swap balls of type <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_0"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_1"> between the two containers, we'll never end up with one container only containing type <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_0"> and the other container only containing type <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_1">. Thus, we print *Impossible* on a new line.

Sample Input 1|Sample Output 1
-|-
2<br>3<br>1 3 1<br>2 1 2<br>3 3 3<br>3<br>0 2 1<br>1 1 1<br>2 0 0|Impossible<br>Possible
