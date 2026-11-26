# 1288. Remove Covered Intervals — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-covered-intervals/

---

## Solution: Sort and Sweep — O(n log n) time, O(1) space

**Idea:** Sort by start ascending, then by end descending (so wider intervals come first). Keep track of max right end seen; skip any interval whose end is ≤ max right.

**Algorithm:**
1. Sort: start ASC, end DESC.
2. Sweep, tracking maxRight.
3. Count intervals where right > maxRight.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
