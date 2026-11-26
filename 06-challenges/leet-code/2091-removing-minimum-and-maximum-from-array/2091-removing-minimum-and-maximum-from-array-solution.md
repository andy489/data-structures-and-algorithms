# 2091. Removing Minimum and Maximum From Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/removing-minimum-and-maximum-from-array/

---

## Solution: Three-Way Comparison — O(n) time, O(1) space

**Idea:** Find positions of min and max. Try 3 ways: both from left, both from right, one each. Take minimum.

**Algorithm:**
1. Find positions minIdx, maxIdx.
2. left = max(minIdx, maxIdx) + 1 (remove both from left).
3. right = n - min(minIdx, maxIdx) (remove both from right).
4. both = (min(minIdx, maxIdx) + 1) + (n - max(minIdx, maxIdx)) (one from each end).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
