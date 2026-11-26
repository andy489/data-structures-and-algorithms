# 617. Merge Two Binary Trees — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/merge-two-binary-trees/

---

## Solution: DFS Recursion — O(min(m,n)) time, O(min(m,n)) space

**Idea:** Recursively merge nodes. If one is null, return the other. If both exist, sum values and recurse on children.

**Complexity:**

| | |
|---|---|
| Time | O(min(m,n)) — only overlapping nodes visited |
| Space | O(min(m,n)) — recursion stack depth |
