[Link](https://www.hackerrank.com/challenges/30-binary-trees/problem)

## Day 23: BST Level-Order Traversal

#### Objective
Today, we're going further with Binary Search Trees. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-binary-trees/tutorial) tab for learning materials and an instructional video!

#### Task
A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes from left to right, top to bottom. You are given a pointer,<img src="https://latex.codecogs.com/svg.latex?\Large&space;root">, pointing to the root of a binary search tree. Complete the levelOrder function provided in your editor so that it prints the level-order traversal of the binary search tree.

**Hint:** You'll find a queue helpful in completing this challenge.

#### Input Format

The locked stub code in your editor reads the following inputs and assembles them into a BST:<br>
The first line contains an integer,<img src="https://latex.codecogs.com/svg.latex?\Large&space;T">(the number of test cases).<br>
The <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> subsequent lines each contain an integer,<img src="https://latex.codecogs.com/svg.latex?\Large&space;data">, denoting the value of an element that must be added to the BST.

#### Output Format

Print the <img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> value of each node in the tree's level-order traversal as a single line of <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> space-separated integers.

#### Sample Input
```
6
3
5
4
7
2
1
```
#### Sample Output
```
3 2 5 1 4 7 
```
#### Explanation

The input forms the following binary search tree:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/LOT%20BST%2001.png)

We traverse each level of the tree from the root downward, and we process the nodes at each level from left to right. The resulting level-order traversal is <img src="https://latex.codecogs.com/svg.latex?\Large&space;3\rightarrow{2}\rightarrow{5}\rightarrow{1}\rightarrow{4}\rightarrow{7}">, and we print these data values as a single line of space-separated integers.
