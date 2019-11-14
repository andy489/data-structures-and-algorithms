
## Task 1.

[Tree: Height of a Binary Tree Judge](https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem)

The height of a binary tree is the number of edges between the tree's root and its furthest leaf. For example, the following binary tree is of height <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/BST%20Height%2001.png)
#### Function Description

Complete the *getHeight* or *height* function in the editor. It must return the height of a binary tree as an integer.

getHeight or height has the following parameter(s):

- *root*: a reference to the root of a binary tree.

**Note** - *The Height of binary tree with single node is taken as zero.*

#### Input Format

The first line contains an integer - the number of nodes in the tree.<br>
Next line contains  space separated integer where the integer denotes <img src="https://latex.codecogs.com/svg.latex?\Large&space;node.data[i]">.

**Note**: *Node values are inserted into a binary search tree before a reference to the tree's root node is passed to your function. In a binary search tree, all nodes on the left branch of a node are less than the node value. All values on the right branch are greater than the node value.*

#### Constraints
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{node.data[i]}\le{20}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{20}"><br>

#### Output Format
Your function should return a single integer denoting the height of the binary tree.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/BST%20Height%2002.png)

#### Sample Output

```
3
```

#### Explanation

The longest root-to-leaf path is shown below:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/BST%20Height%2003.png)

There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> nodes in this path that are connected by  edges, meaning our binary tree's height = <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">.

