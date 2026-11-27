# 1162. As Far from Land as Possible — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/as-far-from-land-as-possible/

---

## Solution: Multi-Source BFS — O(n²) time, O(n²) space

**Idea:** Seed the BFS queue with all land cells simultaneously (distance 0). Expand outward wave by wave; each water cell is reached at its true minimum distance to any land. The last water cell dequeued gives the maximum distance.

**Algorithm:**
1. Enqueue all land cells with distance 0. If none, return -1.
2. BFS expanding to 4 neighbors; skip visited/land cells.
3. Keep track of the last distance recorded (the maximum).
4. If no water cell was ever reached, return -1.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — every cell visited at most once |
| Space | O(n²) — queue can hold all cells |
