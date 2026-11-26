# 1779. Find Nearest Point That Has the Same X or Y Coordinate — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Iterate through all points. A point is valid if it shares the same x or y coordinate with `(x, y)`. Among valid points, track the one with minimum Manhattan distance and smallest index.

**Algorithm:**
1. Initialize `bestDist = infinity`, `bestIdx = -1`.
2. For each point `(a, b)`, if `a == x` or `b == y`, compute `dist = |x - a| + |y - b|`.
3. If `dist < bestDist`, update `bestDist` and `bestIdx`.
4. Return `bestIdx`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra space |
