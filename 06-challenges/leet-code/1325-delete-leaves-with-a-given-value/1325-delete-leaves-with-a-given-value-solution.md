# 1325. Delete Leaves With a Given Value — Solution

## Approach
Postorder DFS: recursively delete children first, then if current node becomes a leaf with target value, return null.

## Complexity
- Time: O(n)
- Space: O(h)
