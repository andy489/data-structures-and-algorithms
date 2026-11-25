# 1020. Number of Enclaves — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-enclaves/

---

## Solution: BFS/DFS from Border — O(m·n) time, O(m·n) space

**Idea:** Flood-fill all land connected to the border, marking it as sea. Count remaining land.

**Algorithm:**
1. BFS from all border land cells, marking visited cells as 0.
2. Count remaining 1s.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) |
| Space | O(m·n) |
