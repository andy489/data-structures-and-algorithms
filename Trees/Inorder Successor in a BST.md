## Inorder Successor in a BST

Problem: Given a node in a binary search tree. Find its inorder successor i.e. the node that would come immediately after the given node in inorder traversal of the binary search tree. 

Lets first recall the inorder algorithm for traversal in a tree:

#### Inorder
1. visit left - subtree
2. visit root
3. visit right - subtree

We first visit the left subtree, then the root and then the right subtree. Left and right subtrees are visited recursively in same manner. So for each node, we first visit its left subtree, then the node itself and then its right subtree. Inorder implementation will basically be a recursive function.

```cpp
Inorder(root)
{
      if(root==nullptr)
      {     //base or exit condition
            return;
      }
      else
      {
            Inorder(root->left); //recur
            Print root->data;
            Inorder(root->right); //recur
      }
}
```
Time complexity is O(n), where n is the number of nodes in the tree (each node is visited exactly once).  Time taken is proportional to a number of nodes in the tree.

To solve the problem we can just perform inorder traversal and while performing inorder traversal we can figure out the successor, but in that case we will have O(n) complexity, so it will be expensive. Findeing nex and previous element in some data could be a frequently performed operation and good thing about binary search tree is that frequently performed operations like insertion, deletion and search happen in O(h), where h is the height of the tree. So it would be good if we are able to find successor and predecessor in O(h). We always try to keep a tree balanced to minimize its height. Height of a balanced binary tree is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\log_2{n}}"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(\log_2{n})})"> running time for any operation is almost the best running time that we can have. So can we find inorder successor in O(h) running time?

Lets analyze inorder traversal:

![](https://i.ibb.co/vmmfx3F/assss.png)
