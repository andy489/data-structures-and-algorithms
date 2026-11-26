# 539. Minimum Time Difference — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-time-difference/

---

## Solution: Sort + Circular Diff — O(n log n) time, O(n) space

**Idea:** Convert all times to minutes (0–1439). Sort the array. The minimum difference is either between adjacent sorted values, or the wrap-around from the last to the first (treating the clock as circular: `1440 - last + first`).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sort |
| Space | O(n) |

## Solution 2: Bucket Sort — O(n) time, O(1) space

Since there are only 1440 possible minute values, use a boolean bucket of size 1440. If a slot is already occupied, return 0. Otherwise scan for minimum gap in sorted order.
