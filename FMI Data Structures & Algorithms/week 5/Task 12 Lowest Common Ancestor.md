## Binary Search Tree : Lowest Common Ancestor

[:owest Common Ancestor Judge](https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem)

You are given pointer to the root of the binary search tree and two values <img src="https://latex.codecogs.com/svg.latex?\Large&space;v1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v2">. You need to return the lowest common ancestor ([LCA](https://en.wikipedia.org/wiki/Lowest_common_ancestor)) of <img src="https://latex.codecogs.com/svg.latex?\Large&space;v1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v2"> in the binary search tree.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Lowest%20Common%20Ancestor%20in%20BST%2001.png)

In the diagram above, the lowest common ancestor of the nodes <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> is the node <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">. Node <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> is the lowest node which has nodes <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> as descendants.

#### Function Description

Complete the function lca in the editor below. It should return a pointer to the lowest common ancestor node of the two values given.

lca has the following parameters:
- root: a pointer to the root node of a binary search tree
- v1: a node.data value
- v2: a node.data value

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the number of nodes in the tree.<br>
The second line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> space-separated integers representing <img src="https://latex.codecogs.com/svg.latex?\Large&space;node.data"> values.<br>
The third line contains two space-separated integers,<img src="https://latex.codecogs.com/svg.latex?\Large&space;v1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v2">.

To use the test data, you will have to create the binary search tree yourself. Here on the platform, the tree will be created for you.

#### Constraints
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n,node.data}\le{25}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{v1,v2}\le{25}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;v1\neq{v2}">

The tree will contain nodes with data equal to <img src="https://latex.codecogs.com/svg.latex?\Large&space;v1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v2">.

#### Output Format

Return the a pointer to the node that is the lowest common ancestor of <img src="https://latex.codecogs.com/svg.latex?\Large&space;v1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v2">.

#### Sample Input
```
6
4 2 3 1 7 6
1 7
```
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Lowest%20Common%20Ancestor%20in%20BST%2002.png)

<img src="https://latex.codecogs.com/svg.latex?\Large&space;v1=1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v2=7">.

#### Sample Output

[reference to node 4]

#### Explanation

LCA of <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;7"> is <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">, the root in this case.
Return a pointer to the node.
