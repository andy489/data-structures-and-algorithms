# 637. Average of Levels in Binary Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/average-of-levels-in-binary-tree/

---

## Solution: BFS Level Order — O(n) time, O(n) space

**Idea:** BFS level by level; compute the average of each level.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits each node once |
| Space | O(n) — BFS queue width |
