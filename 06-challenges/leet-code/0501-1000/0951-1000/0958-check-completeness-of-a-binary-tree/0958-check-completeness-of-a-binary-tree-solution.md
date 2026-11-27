# 958. Check Completeness of a Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-completeness-of-a-binary-tree/

---

## Solution: BFS Level Order — O(n) time, O(n) space

**Idea:** BFS. Once we see a null node, all subsequent nodes must also be null.

**Algorithm:**
1. BFS, adding both left and right children (including nulls).
2. Once a null is dequeued, set a flag; if any non-null follows, return false.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — queue |
