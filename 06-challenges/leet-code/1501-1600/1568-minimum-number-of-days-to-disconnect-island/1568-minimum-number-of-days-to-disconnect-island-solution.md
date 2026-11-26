# 1568. Minimum Number of Days to Disconnect Island — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/

---

## Solution: Articulation Points — O(m * n) time, O(m * n) space

**Idea:** The answer is at most 2 (any corner of the island can be removed to disconnect). It is 0 if already disconnected. It is 1 if any articulation point (AP) exists in the land graph. Otherwise it is 2. Use Tarjan's algorithm to find articulation points.

**Algorithm:**
1. Count islands. If != 1, return 0.
2. If only one land cell, return 1.
3. Run Tarjan's AP detection on the land cells.
4. If an AP exists, return 1; otherwise return 2.

**Complexity:**

| | |
|---|---|
| Time | O(m * n) — single DFS pass over the grid |
| Space | O(m * n) — discovery and low arrays |
