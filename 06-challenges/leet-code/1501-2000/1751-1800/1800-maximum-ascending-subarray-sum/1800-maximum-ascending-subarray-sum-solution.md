# 1800. Maximum Ascending Subarray Sum — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-ascending-subarray-sum/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Scan through the array maintaining the current ascending subarray sum. When the current element is not greater than the previous, start a new subarray. Track the maximum sum seen.

**Algorithm:**
1. Initialize `curSum = nums[0]`, `ans = nums[0]`.
2. For each `i` from 1 to n-1:
   - If `nums[i] > nums[i-1]`: `curSum += nums[i]`.
   - Else: `curSum = nums[i]`.
   - Update `ans = max(ans, curSum)`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra space |
