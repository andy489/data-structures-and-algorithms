## Binary Tree Traversal

When we are working with trees, we may often want to visit all the nodes in the tree. Tree is not a linear data structure like array or linked list. In a linear data structure there would be a logical start and a logical end. So, we can start with a pointer at one of the ends and keep moving it forwards the other end. For a linear data structure like linked list, for each node or element we would have only one next element. But tree is not a linear data structure. For a tree at any time if we are pointing to a particular node then we can have more than one possible directions (more than one possible next nodes). And of course if we will go in one direction then we will somehow have to come back and go into the other direction later. So tree traversal is not so straightforward.

#### Tree Traversal 
- *the process of visiting each node in the tree exactly once in some order. By visiting a node we mean reading or processing data in the node.*

For simplicity to us visit will mean printing the data in the node. based on the order in which nodes are visited, tree traversal algorithms can broadly be classified into two categories:
- **Breadth-first** *- level order* 
- **Depth-first** *- DLR, LDR, LRD*

Breadth-first traversal and Depth-first traversal are general techniques to traverse or search a graph. A graph is a data structure and tree is only a special kind of graph. Here we are going to discuss breadth-first and depth-first traversal in context of trees. In a tree, in breadth-first approach we would visit all the nodes at same depth or level, before visiting the nodes at next level. What we can do in breadth-first approach is that we can start at leve-0, we would have only one node at level-0, which is the root node. So we can visit the root node and print the data in the node as we visit it. Now level-0 is done and we can go to level-1 and visit the nodes from left to right. After we are done with level-1, we can go to level-2 and etc. This kind of breath-first traversal in tree is called level order traversal. 

*We are going level-by-level from left-to-right in breadth-first traversal.* For any node we visit all its children before visiting any of its grandchildren.

But in depth-first approach if we would go to a child, we would complete the whole subtree of the child before going to the next child. In depth-first approach the relative order of visiting the left subtree, the right subtree and the root node can be different. For example we can first visit the right subtree, and then the root, and then the left subtree. Or we can do something like: we can first visit the root and then the left subtree and then the right subtree. So the relative order can be different but the core idea in depth-first strategy is that visiting a child is visiting the complete subtree in that path (visiting a node is reading, processing or printing the data in that node). Based on the relative order of left subtree, right subtree and the root there are three popular depth-first strategies:

- < root node > < left subtree > < right subtree > - *Preorder traversal*
- < left subtree > < root node > < right subtree > - *Inorder traversal*
- < left subtree > < right subtree > < root node > - *Postorder traversal*

In total there are six possible permutations for left, right and root but conventionally a left subtree is always visited before the right subtree. So these are the three strategies that we use only the position of root is changing here. There is an easy way to remember these three depth-first algorithms. If we can denote visiting a node or reading the data in that node with letter 'D' going to the left subtree as 'R'. SO if we can say D for Data, L for Left and R for Right then in pre-order for each node we will go DLR, first we will read the data in tht node then we will go left and once the left subtree is done we will go right. In inorder traversal first we will finih the left subtree, then we will read the data in current node and then we will go right. In postorder for each node first we will go left, once left subtree is done we will go right and then we will read data in current node. Preorder, inorder and postorder are really easy and intuitive to implement using recursion.

***Inorder traversal of a binary search tree would give you a sorted list.***
