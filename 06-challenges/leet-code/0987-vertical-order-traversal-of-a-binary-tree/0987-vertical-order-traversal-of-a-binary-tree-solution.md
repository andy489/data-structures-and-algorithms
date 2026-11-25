# 987. Vertical Order Traversal of a Binary Tree — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

---

## Solution: DFS + Sort — O(n log n) time, O(n) space

**Idea:** Collect (col, row, val) for each node. Sort by col, then row, then val. Group by col.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
