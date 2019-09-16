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

Maximum no. of nodes in a tree with height h is <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^0+2^1+...">
