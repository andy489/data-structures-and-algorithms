## Binary Tree

Binary tree is a tree with the property that each node in the tree can have at most two children.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Binary_tree.svg/1200px-Binary_tree.svg.png)

In the above tree each node have either zero, one or two children. Le call one of the children left chile and another right child. For the root node 2, the node 7 is the left child and the node 5 is the right child. In a program, we would set the reference or pointer to left or right child as NULL (nullptr). So, we can say that for right child of 9 is NULL and similarly left and right childs of 4 are both NULL. For all nodes that do not have children, that are leaf nodes (a node with 0 childs is called a leaf) we can say that both left and right child are NULL. 

#### Strict / Proper Binary Tree

A binary tree is called **strict binary tree** or **proper binary tree** if each node can have *either 2 or 0 children*. In the above example the tree we are showing is not a strict binary tree because we have two nodes with exactly one child. We can make it a strict binary tree if we get rid of nodes 9 and 4.

#### Complete Binary Tree

We call a binary tree **complete binary tree** if all levels except possibly the last level are completely filled and all nodes are as far left as possible. All levels except possibly the last level will anyway be filled. So, the nodes at the last level, if its not filled completely must be as far left as possible. 

In the above example the tree is not complete, because we are missing a node at the second level and at the last level the nodes are not most-left oriented (we have two vacant positions at the left side of the tree). Here is an example of complete binary tree:

![](https://upload.wikimedia.org/wikipedia/commons/3/38/Max-Heap.svg)

If we go numbering all the levels in the tree like L-0, L-1, L-2 and so on, then the maximum number of nodes that we can have at some level *i*, will be equal to 2 to the power *i*. 

As we say, for a complete binary tree, all the levels have to be completely filled. In order a binary tree to be complete binary tree we can give exception to the last level or deepest level. It doesn't have to be full. But the nodes have to be as left as possible. *If all the levels are complete filled*, such a *binary tree* can also be called **perfect binary tree**. 

Maximum no. of nodes in a binary tree with height h is <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^0+2^1+...+2^h=2^{h+1}-1=2^{no.OfLevels}-1">. At deepest level we will have 2 to the power *h* nodes.

What will be height of a perfect binary tree with N nodes? Lets say N is the number of nodes in a perfect binary tree. So to find out the hight we have to solve the following equation:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;n=2^{h+1}-1">. Thus, <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{h+1}=(n+1)\Rightarrow{h=\log_2{(n+1)}-1}">.

In general we can also calculate the hight of a complete binary tree: <img src="https://latex.codecogs.com/svg.latex?\Large&space;\lfloor\log_2{n}\rfloor">, because perfect binary tree is also a complete binary tree. All this maths will be really helpful when we will analyze cost of various operations on binary tree. Cost of a lot of operations on tree in terms of time depends upon the height of tree. For example, in *binary search tree* which is a special kind of binary tree, the cost of searching, inserting or removing an element in terms of time is proportional to the height of tree. So, in such case we would want the height of the tree to be less. Hight of a tree will be less if the tree will be dense, if the tree will be close to a perfect binary tree or a complete binary tree. Minimum height of a tree with n nodes can be <img src="https://latex.codecogs.com/svg.latex?\Large&space;\log_2{n}"> when the tree will be a complete binary tree. With n nodes, minimum height possible is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\lfloor\log_2{n}\rfloor"> and maximum height possible with n nodes is n-1 when we will have a sparse tree which is as good as a linked list. 

Now, lets think about this: if we are saying that time taken for an operation is proportional to height of the tree or in other words we can say that if time complexity of an operation is *O(h)* where *h* is the height of the binary tree, then for a complete or perfect binary tree, our time complexity will be <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(\log_2{n})"> and in worst case for a sparse tree, our time complexity will be O(n). *Order of <img src="https://latex.codecogs.com/svg.latex?\Large&space;\log_2{n}"> is almost best running time possible*. For n as high as <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{100}">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;\log_2{n}"> is just 100. With order of n running time, if n will be <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{100}">, we won't be able to finish our computation in years even with most powerful machines ever made. So, here is the thing. Quite often we want to keep the height of a binary tree minimum possible or most commonly, we say that we try to keep a binary tree *balanced*.

#### Balanced Binary Tree

We call a binary tree **balanced binary tree**, if for each node, the difference between height of left and right sub-tree is not more than some number *k*. Mostly *k* would be 1. So, we can say that for each node, diference between height of left and right sub-tree should not be more than 1. 


For all nodes in a perfect tree, absolute difference between left sub-tree and right sub-tree will be zero. We try to keep a tree balanced to make sure its dense and its height is minimized. If height is minimized, cost of various operations that depend upon height are minimized.

We can implement binary tree using:
- a) dynamically created nodes at random locations in memory, linked to each other using pointers or references
- b) arrays (in some special cases). Arrays are typically used for complete binary trees

In a perfect binary tree (assuming it is a tree of integers) with n nodes we can number its nodes from 0 starting at root and going level by level from left to right. After that we can create an array of n integers and the indexes can be used to store a certain node's data. IN case of complete binary tree if we numbered the nodes like we've described, then for a node with index *i*, the index of left child will be *2.i+1* and the index of right child will be *2.i+2* (*true only for complete binary tree!*).
