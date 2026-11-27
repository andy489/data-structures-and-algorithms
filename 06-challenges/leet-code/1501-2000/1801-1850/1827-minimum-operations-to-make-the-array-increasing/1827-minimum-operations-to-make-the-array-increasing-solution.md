# 1827. Minimum Operations to Make the Array Increasing — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** Scan left to right. Whenever `nums[i] <= nums[i-1]`, we must increment `nums[i]` to `nums[i-1] + 1`. The number of operations needed is the difference `(nums[i-1] + 1) - nums[i]`. Update `nums[i]` in place so future comparisons use the adjusted value.

**Algorithm:**
1. For each index `i` from 1 to n-1:
   - If `nums[i] <= nums[i-1]`: add `nums[i-1] - nums[i] + 1` to `ops`, set `nums[i] = nums[i-1] + 1`.
2. Return `ops`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the array |
| Space | O(1) — modifies array in place, no extra storage |
