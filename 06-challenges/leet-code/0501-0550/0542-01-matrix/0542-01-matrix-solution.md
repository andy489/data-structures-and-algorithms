# 542. 01 Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/01-matrix/

---

## Solution: Multi-Source BFS — O(m·n) time, O(m·n) space

**Idea:** Seed BFS queue with all 0-cells at distance 0. Expand outward; each neighboring 1-cell that hasn't been visited gets distance = current + 1.

**Algorithm:**
1. Initialize result matrix with MAX_VALUE; set all 0-cells to 0 and add them to queue.
2. BFS: for each cell dequeued, check 4 neighbors; if `dist[r][c] + 1 < dist[nr][nc]`, update and enqueue.
3. Return result matrix.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — each cell processed once |
| Space | O(m·n) — queue and result matrix |
