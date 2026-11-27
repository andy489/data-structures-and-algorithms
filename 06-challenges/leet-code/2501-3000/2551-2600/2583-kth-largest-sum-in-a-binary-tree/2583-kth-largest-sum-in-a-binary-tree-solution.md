# Solution: 2583. Kth Largest Sum in a Binary Tree

## Approach: BFS Level Order + Sorting

**Algorithm:**
1. Perform BFS (level-order traversal) on the tree.
2. For each level, compute the sum of all node values.
3. Collect all level sums in a list.
4. Sort the list in descending order and return the k-th element (0-indexed: k-1).
5. If the number of levels is less than k, return -1.

**Alternative:** Use a min-heap of size k to find the k-th largest without fully sorting. But given constraints, full sort is acceptable.

## Complexity

- **Time:** O(n + L log L) where L = number of levels (at most log n for balanced, up to n)
- **Space:** O(n) for BFS queue
