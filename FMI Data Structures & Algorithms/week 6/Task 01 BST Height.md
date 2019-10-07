
## Task 1.
The height of a binary tree is the number of edges between the tree's root and its furthest leaf. For example, the following binary tree is of height 2:

![image](assets/1527626183-88c8070977-isitBSTSample0.png)
**Function Description**

Complete the *getHeight* or *height* function in the editor. It must return the height of a binary tree as an integer.

getHeight or height has the following parameter(s):

- *root*: a reference to the root of a binary tree.

**Note** -The Height of binary tree with single node is taken as zero.

**Input Format**

The first line contains an integer , the number of nodes in the tree. 
Next line contains  space separated integer where th integer denotes node[i].data.

**Note**: Node values are inserted into a binary search tree before a reference to the tree's root node is passed to your function. In a binary search tree, all nodes on the left branch of a node are less than the node value. All values on the right branch are greater than the node value.

**Constraints**

 1 <= node.data[i] <= 20

1 <= n <= 20

**Output Format**

Your function should return a single integer denoting the height of the binary tree.

**Sample Input**

![image](assets/1527625966-0f80a8e1a4-treeDepthSample0.png)

**Sample Output**

```
3
```

**Explanation**

The longest root-to-leaf path is shown below:

![image](assets/1527626088-807ca5fc63-treeDepthSample1.png)

There are 4 nodes in this path that are connected by  edges, meaning our binary tree's height = 3.

