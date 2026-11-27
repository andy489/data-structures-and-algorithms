# 1620. Coordinate With Maximum Network Quality — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/coordinate-with-maximum-network-quality/

---

## Solution: Grid Brute Force — O(C^2 * T) time, O(1) space

**Idea:** Since all coordinates are bounded by `[0, 50]`, enumerate every integral coordinate `(x, y)` in `[0, 50] x [0, 50]`. For each coordinate, compute the total network quality by summing contributions from all reachable towers. Track the maximum quality and its lexicographically smallest coordinate.

**Algorithm:**
1. For each `(x, y)` from `(0, 0)` to `(50, 50)`:
   a. For each tower `(tx, ty, q)`, compute `d^2 = (x - tx)^2 + (y - ty)^2`.
   b. If `d^2 <= radius^2`, add `floor(q / (1 + sqrt(d^2)))` to the quality.
2. Track maximum quality; on tie, the first (lexicographically smallest) wins since we scan in order.
3. Return the best coordinate.

**Complexity:**

| | |
|---|---|
| Time | O(C^2 * T) — C = 51 (coordinate range), T = number of towers |
| Space | O(1) — constant extra space |
