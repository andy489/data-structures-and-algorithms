# 1730. Shortest Path to Get Food — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-path-to-get-food/

---

## Solution: BFS — O(m · n) time, O(m · n) space

**Idea:** Standard BFS from the starting cell `'*'`. The first time any food cell `'#'` is reached, return the current distance (BFS guarantees shortest path on unweighted grid).

**Algorithm:**
1. Find `'*'` position and enqueue it with distance `0`.
2. BFS: for each cell, try all 4 neighbors; skip if obstacle `'X'` or already visited.
3. Return distance when `'#'` is reached; return `-1` if queue exhausts.

**Complexity:**

| | |
|---|---|
| Time | O(m · n) — each cell visited at most once |
| Space | O(m · n) — visited array and queue |
