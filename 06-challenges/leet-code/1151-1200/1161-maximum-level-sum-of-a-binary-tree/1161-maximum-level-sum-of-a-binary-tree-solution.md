# 1161. Maximum Level Sum of a Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

---

## Solution: BFS Level-Order Traversal — O(n) time, O(w) space

**Idea:** Process the tree level by level using BFS. For each level, sum all node values and track the level with the maximum sum (keeping the smallest level on ties).

**Algorithm:**
1. Use a queue initialized with the root.
2. At each level, sum all node values in the current level.
3. If the sum exceeds the best seen so far, update the best sum and record the current level.
4. Return the best level.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(w) — queue holds at most one full level (w = max width) |
