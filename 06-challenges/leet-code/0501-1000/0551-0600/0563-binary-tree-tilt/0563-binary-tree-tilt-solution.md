# Solution: Binary Tree Tilt

## Approach
Post-order DFS: for each node compute the subtree sum, accumulate the absolute difference into a running total, and return the subtree sum to the parent.

**Time:** O(n) | **Space:** O(h)
