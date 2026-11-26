# 559. Maximum Depth of N-ary Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

---

## Solution: DFS — O(n) time, O(h) space

**Idea:** Recursively return 1 + max depth among all children.

**Algorithm:**
1. If root is null, return 0.
2. If root has no children, return 1.
3. Return `1 + max(dfs(child) for each child)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit every node |
| Space | O(h) — recursion stack |
