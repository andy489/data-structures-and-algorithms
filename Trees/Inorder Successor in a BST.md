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

To solve the problem we can just perform inorder traversal and while performing inorder traversal we can figure out the successor, but in that case we will have O(n) complexity, so it will be expensive. Finding next and previous element in some data could be a frequently performed operation and good thing about binary search tree is that frequently performed operations like insertion, deletion and search happen in O(h), where h is the height of the tree. So it would be good if we are able to find successor and predecessor in O(h). We always try to keep a tree balanced to minimize its height. Height of a balanced binary tree is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\log_2{n}}"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(\log_2{n})})"> running time for any operation is almost the best running time that we can have. So can we find inorder successor in O(h) running time?

Let's analyze inorder traversal:

![](https://i.ibb.co/jh9d2Gj/BST1.png)
![](https://i.ibb.co/RTcfZjk/BST2.png)
![](https://i.ibb.co/6Bhvsf8/BST3.png)

Notice that we have printed the integers (in our case the data in the note is of type int) in sorted order. When we perform inorder traversal on a binary search tree then elements are visited in sorted order. 

![](https://i.ibb.co/kQzfyWX/BST4.png)

What node would we visit after node with value 10? Now, can we deduce this algorithm logically. Well, if we see the simulation of inorder traversal that we had done earlier and we have already visited this node, then we are done with its left subtree and we have read the data in this node and we need to go right.

![](https://i.ibb.co/YTQp9yH/BST5.png)

Now, in the right subtree, we will have to go left as long as it's possible to go and if we can't go left anymore - there's nothing left of the node with value 11 in our example, then this is the node that we're visiting next. So for a node, if there is a right subtree, then inorder successor would be the left most node in it's right subtree. In a BST it would be the node with minimum value in its right subtree. So, this was the case one.

#### Case 1: Node has right subtree
- *Go deep to leftmost node in right subtree OR find min in right subtree*

What would be the successor if there would be no right subtree? What node would we visit after this node with value 8. This node does not have right subtree.

![](https://i.ibb.co/rp0Ymty/BST6.png)

If we have already visited the node with value 8, then we have already visited its left subtree and its node itself and there is nothing in right, so we can see that right is also visited but we have not found a successor yet. Now where do we go from here? Well if we remember the simulation done earlier for LDR traversal (inorder traversal) - we need to go to the parent form left and if we are going to the parent of left , which is the case here, then the parent would be unvisited. For the node with value 10, we just finished its left subtree and we're coming back. So now we can visit node with value 10 and this is our successor.

![](https://i.ibb.co/tbLdqd4/BST7.png)
