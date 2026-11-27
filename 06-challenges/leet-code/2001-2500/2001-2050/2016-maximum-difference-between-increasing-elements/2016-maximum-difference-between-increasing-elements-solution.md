# 2016. Maximum Difference Between Increasing Elements — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-difference-between-increasing-elements/

---

## Solution: Track Running Minimum — O(n) time, O(1) space

**Idea:** Track the minimum seen so far. For each element, update the max difference.

**Algorithm:**
1. Initialize `minVal = nums[0]`, `res = -1`.
2. For each `nums[j]`, if `nums[j] > minVal`, update `res = max(res, nums[j] - minVal)`.
3. Update `minVal = min(minVal, nums[j])`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
