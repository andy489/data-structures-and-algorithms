## Depth-first Traversal

- Preorder
- Inorder
- Postorder

In depth-first traversal of binary tree if we go in one direction then we visit all the nodes in that direction or in other words we visit the complete subtree in that direction and then only we go in other direction. If we are at root at some tree and we are going left then we will visit all the nodes in the left subtree and then only we can go right. And once again if we go right, then we will visit all the nodes in the right subtree and then only we will go left. In this approach we are reducing the problem in a self-similar or recursive manner. We can say that in total, visiting all the nodes in the tree is visiting the root node, visiting the left subtree and visiting the right subtree (by visiting a node we mean reading or processing the data in that node and by visiting a subtree we mean visiting all the nodes in the subtree). In depth-first strategy relative order of visiting the left subtree, right subtree and the root can be different. For example we can first visit the right subtree then the root and then the left subtree or we can first visit the root and then the left subtree and then the right subtree. Conventionally left subtree is always visited before right subtree. With this constraint we will have three permutations:

- Preorder traversal
  - < root > < left > < right >
- Inorder traversal
  - < left > < root > < right >
- Postorder traversal
  - < left > < right > < root >
  
Left and right subtree will be visited recursively in same manner as the original tree, so in preorder once again for the subtree we will go root, left and then right. The actual implementation of this algorithms is really intuitive. Lets first see the code for preorder traversal.

### Preorder
1. visit root
2. visit left subtree
3. visit right subtree

### Inorder
1. visit left subtree
2. visit root
3. visit right subtree

### Postorder
1. visit left subtree
2. visit right subtree
3. visit root

We want to write a function that should take a pointer or reference to root node as argument and print data in all the nodes in preorder. 

There is one thing that we must mention here for what is happening in this whole process in this algorithm. Even though we are not using any extra memory explicitly in our function, because of the recursion we are growing the function call stack. For each function call we allocate some amount of memory in what we call stack section of applications memory and this allocated memory is reclaimed when the function call finishes. So even though we are not using any extra memory explicitly, we are using memory implicitly in the call stack. Space complaxity, which is measure of rate of growth of extra memory used with input will depend upon the maximum amount of extra memory used in the call stack. The call stack will grow only untill we reach a leaf node, a node with no children and then it will start shrinking again. Maximum growth of call stack to do this recursion will depend upon maximum depth or height of the tree. We can say that extra space used will be proportional to height of the tree or in othre words space complexity of this algorithm is O(h), where h is the height of the tree.

Time complexity of all these three algorithms is O(n). There is only one function call corresponding to each node where we were actually visiting that node, where we were actually printing the data in that node, so running time should actually be proportional to number of nodes. There is a better formal and mathematical way of proving that time complexity of these algorithms is O(n). You can see [here](https://en.wikipedia.org/wiki/Master_theorem_(analysis_of_algorithms)).

- Time complexity: O(n)
- Space complexity: O(h)
  - Worst: O(n)
  - Best/Average: O(log(n))
  
[Here you can see the code implemented in C++ for preorder, inorder and postorder order traversal in binary tree.](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Preorder%2C%20Inorder%2C%20Postorder%20traversals%20in%20BT.cpp)
