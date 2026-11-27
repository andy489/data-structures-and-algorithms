# 462. Minimum Moves to Equal Array Elements II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

---

## Solution: Median — O(n log n) time, O(1) space

**Idea:** The optimal meeting point minimizing total L1 distance is the median. Sort the array, pick the median, then sum absolute differences.

**Algorithm:**
1. Sort `nums`.
2. Set `median = nums[n / 2]`.
3. Return sum of `|nums[i] - median|` for all `i`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(1) |
