# 2246. Longest Path With Different Adjacent Characters — Solution

## Approach

Build an adjacency list (children list) from the parent array. Then run DFS from the root.

For each node, perform DFS on all children and collect their longest paths (only counting a child if its character differs from the current node's character). Keep the top 2 longest valid child paths. The longest path through the current node = top1 + top2 + 1. Update global answer.

Return the longest path going downward from the current node = top1 + 1.

## Complexity

- **Time:** O(n)
- **Space:** O(n)
