# 1091. Shortest Path in Binary Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-path-in-binary-matrix/

---

## Solution: BFS — O(n²) time, O(n²) space

**Idea:** BFS from top-left. Each level = distance +1. Use 8-directional movement.

**Algorithm:**
1. If start or end is blocked, return -1.
2. BFS from (0,0). Track visited by marking grid.
3. When we reach (n-1, n-1), return distance.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) |
