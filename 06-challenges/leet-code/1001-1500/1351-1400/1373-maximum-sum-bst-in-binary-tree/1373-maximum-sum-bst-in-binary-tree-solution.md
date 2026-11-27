# 1373. Maximum Sum BST in Binary Tree — Solution

## Approach
Postorder DFS. Each call returns (isBST, minVal, maxVal, sum). If left and right are BSTs and root > left.max and root < right.min, then current is a BST.

## Complexity
- Time: O(n)
- Space: O(h)
