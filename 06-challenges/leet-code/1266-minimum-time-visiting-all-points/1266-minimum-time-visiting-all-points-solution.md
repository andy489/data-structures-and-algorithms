# 1266. Minimum Time Visiting All Points — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-time-visiting-all-points/

---

## Solution: Chebyshev Distance — O(n) time, O(1) space

**Idea:** The minimum steps between two points (allowing diagonal) is the Chebyshev distance: max(|dx|, |dy|).

**Algorithm:**
1. For each consecutive pair, compute max(|x2-x1|, |y2-y1|).
2. Sum all distances.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
