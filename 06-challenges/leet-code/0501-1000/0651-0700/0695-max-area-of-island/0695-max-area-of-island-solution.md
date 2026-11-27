# 695. Max Area of Island — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/max-area-of-island/

---

## Solution: DFS — O(m·n) time, O(m·n) space

**Idea:** DFS from each unvisited land cell, counting the area and marking visited by setting to 0.

**Algorithm:**
1. For each cell with value 1: DFS to count connected area, update max.
2. DFS: mark current cell as 0, recurse to 4 neighbors.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) |
| Space | O(m·n) — recursion stack |

## Solution 2: BFS — O(m·n) time, O(m·n) space

Same idea using BFS queue instead of recursion.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) |
| Space | O(m·n) |
