# 993. Cousins in Binary Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/cousins-in-binary-tree/

---

## Solution: BFS — O(n) time, O(n) space

**Idea:** BFS level by level. At each level check if both x and y are found with different parents.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — queue |
