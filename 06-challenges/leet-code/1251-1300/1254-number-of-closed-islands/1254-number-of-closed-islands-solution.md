# 1254. Number of Closed Islands — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-closed-islands/

---

## Solution: DFS Flood Fill — O(m*n) time, O(m*n) space

**Idea:** First flood-fill all land connected to borders (mark as water). Then count remaining land components.

**Algorithm:**
1. DFS from all border 0s, marking them as 1.
2. Count distinct 0-components in the interior.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) |
| Space | O(m*n) |
