# 2905. Find Indices With Index and Value Difference II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii/

---

## Solution: Two Pointers with Min/Max Tracking — O(n) time, O(1) space

**Idea:** Maintain two pointers `i` and `j` where `j - i >= indexDifference`. As `j` advances, we look at index `i = j - indexDifference` and maintain the running minimum and maximum of `nums[0..i]` with their indices. For each `j`, check if `nums[j]` differs from the tracked min or max by at least `valueDifference`.

**Algorithm:**
1. For each `j` starting from `indexDifference`, let `i = j - indexDifference`.
2. Update running `minVal/minIdx` and `maxVal/maxIdx` with index `i`.
3. If `nums[j] - minVal >= valueDifference`, return `[minIdx, j]`.
4. If `maxVal - nums[j] >= valueDifference`, return `[maxIdx, j]`.
5. If nothing found, return `[-1, -1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
