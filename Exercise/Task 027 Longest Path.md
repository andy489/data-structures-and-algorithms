## Longest Path

[Judge System](https://www.hackerrank.com/contests/101hack33/challenges/longest-path)

You are given a tree with nodes. Each node can either be black or white. You need to find the longest path in this tree that consists only of black nodes.
Nodes are numbered from to

.

#### Input Format

The first line contains
the number of nodes. The second line contains integers, representing the colour of node . Here, is for a white node and for a black node.
The next line contains integers. The integer (-indexed) represents the parent of node , which is between and .

is considered the root of the tree. You can assume that the input is a valid tree.

#### Constraints

#### Output Format

Output the length of the longest path containing only black nodes.

#### Sample Input
```
5   
1 1 0 1 1   
1 2 3 4
```
#### Sample Output
```
2
```
#### Explanation

The given tree is a path
where is a white node.
So, the longest path in this tree with only black nodes is of length , which is or .
