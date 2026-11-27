# Solution: K-th Largest Perfect Subtree Size in Binary Tree

## Approach: Post-order DFS

Perform a post-order DFS. For each node, determine if its subtree is a perfect binary tree.

A subtree rooted at `node` is perfect if:
- It is a leaf (size = 1), OR
- Both left and right subtrees are perfect AND have the same size.

If perfect, the total size = left_size + right_size + 1.

Collect all perfect subtree sizes, sort in descending order, and return the k-th element (1-indexed) or -1 if there are fewer than k elements.

## Complexity

- **Time:** O(n log n) — O(n) DFS + O(n log n) sort.
- **Space:** O(n) for the sizes list.
