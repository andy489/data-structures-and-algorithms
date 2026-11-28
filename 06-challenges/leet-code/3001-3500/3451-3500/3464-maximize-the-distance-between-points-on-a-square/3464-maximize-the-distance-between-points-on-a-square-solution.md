# 3464. Maximize the Distance Between Points on a Square — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/

---

## Solution: Binary Search + Greedy Verification — O(n log n) time, O(n) space

**Idea:** Binary search on the answer (minimum distance d). For a given d, verify if we can greedily select k points on the square boundary with Manhattan distance >= d between consecutive selected points. Map all points to a 1D perimeter coordinate and greedily pick.

**Algorithm:**
1. Map each point to a 1D position along the perimeter (0 to 4*side).
2. Sort points by perimeter position.
3. Binary search on d from 0 to 2*side.
4. For each candidate d, greedily check if k points can be selected with consecutive Manhattan distance >= d (wrap around the perimeter).
5. Return the maximum valid d.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
