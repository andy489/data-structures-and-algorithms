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

Let's now pick another node with no right subtree. What would be inorder successor for node with value 12? What node would be visit next?

[!](https://i.ibb.co/KL4B3Rt/BST8.png)

Now here, once again, we do not have right subtree for this node with value 12, so we must go back to its parent and see if it's unvisited. But if we're going to the parent from right, if the node that we just visited is a right child, which is the case here, then the parent would already be visited, because we are coming back after visiting its right subtree. The node with value 10 must have been visited before going right. So what should we do? Now the recursion will rollback further and we need to go to parent of node with value 10. And now we are going to node with value 15 from left. So this is our guy, because its unvisited (node with value 15 is our searched inorder successor).

![](https://i.ibb.co/bXxZMKY/BST9.png)

#### Case 2: No right subtree
- *Go to the nearest ancestor for which given node would be in left subtree*

IN the above example we went from node with value 12 to node with value 10, but node with value 12 is in right subtree of node with value 10, so we went to the next ancestor - node with value 15. Now node with value 12 in in left of 15, so this is the nearest ancestor for which node with value 12 is in left and hence this is our inorder successor.

This algorithm works fine but there is an issue. How do we go from a node to its parent? Well, we can design a tree such that node can have reference to its parent. 
```cpp
struct Node
{
      Node* left;
      int data;
      Node* right;
      Node* parent; //additional pointer to store the address of parent
}
```
Often it makes a lot of sense to have one more field to store the address of parent. We can design a tree like this and then e will not have problem walking the tree up using parent link. We can easily go to the ancestors. 

But what if there is no link to parent? In this case what we can do is we can start at root and walk the tree from root to the given node. IN a BST this is really easy. For node with value 12 we will start at root. 12 is lesser than value in root so we need to go left. Now we are at node with value 10. Now 12 is greater than 10, so we need to go right and now we are at node with value 12. If we will walk the tree from root to the given node, we will go through all the ancestors of the given node. Inorder successor would be the deepest node or deepest ancestors in this path for which given node would be in left subtree. Node with value 12 has only two ancestors. We have node with value 10, but it is on the right and then node with value 15, which is on the left, so node with value 15 is our successor. We need to look at ancestors only if there is no right subtree.

[C++ code for the described algorithm here](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Inorder%20Successor%20in%20a%20BST.cpp)
