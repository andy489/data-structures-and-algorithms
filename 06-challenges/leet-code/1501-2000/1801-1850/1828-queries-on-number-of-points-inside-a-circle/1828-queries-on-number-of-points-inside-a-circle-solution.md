# 1828. Queries on Number of Points Inside a Circle — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/

---

## Solution: Brute Force — O(n*q) time, O(1) space

**Idea:** For each query circle `(cx, cy, r)`, iterate over all points and check if the squared Euclidean distance `(px-cx)^2 + (py-cy)^2 <= r^2`. This avoids floating-point arithmetic and handles the "on border" inclusion requirement exactly.

**Algorithm:**
1. For each query `[cx, cy, r]`:
   - Count points `[px, py]` where `(px-cx)^2 + (py-cy)^2 <= r^2`.
2. Return the counts array.

**Complexity:**

| | |
|---|---|
| Time | O(n * q) — for each of q queries, check all n points |
| Space | O(1) — only the output array (not counted as extra space) |
