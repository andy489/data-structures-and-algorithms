[Link](https://www.hackerrank.com/challenges/30-binary-search-trees/problem)

## Day 21: Binary Search Trees

#### Objective
Today, we're working with Binary Search Trees (BSTs). Check out the [Tutorial](https://www.hackerrank.com/challenges/30-binary-search-trees/tutorial) tab for learning materials and an instructional video!

#### Task
The height of a binary search tree is the number of edges between the tree's root and its furthest leaf. You are given a pointer,<img src="https://latex.codecogs.com/svg.latex?\Large&space;root">, pointing to the root of a binary search tree. Complete the getHeight function provided in your editor so that it returns the height of the binary search tree.

#### Input Format

The locked stub code in your editor reads the following inputs and assembles them into a binary search tree:<br>
The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, denoting the number of nodes in the tree.<br>
Each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> subsequent lines contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;data">, denoting the value of an element that must be added to the BST.

#### Output Format

The locked stub code in your editor will print the integer returned by your getHeight function denoting the height of the BST.

#### Sample Input
```
7
3
5
2
1
4
6
7
```
#### Sample Output
```
3
```
#### Explanation

The input forms the following BST:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Height%20of%20a%20Binary%20Tree%2001.png)

The longest root-to-leaf path is shown below:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Height%20of%20a%20Binary%20Tree%2002.png)

There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> nodes in this path that are connected by <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> edges, meaning our BST's <img src="https://latex.codecogs.com/svg.latex?\Large&space;height=3">. Thus, we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> as our answer.
