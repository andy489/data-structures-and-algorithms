# 910. Smallest Range II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-range-ii/

---

## Solution: Sort + Greedy — O(n log n) time, O(1) space

**Idea:** Sort the array. The optimal split point is some index i where elements 0..i get +k and i+1..n-1 get -k. Try all split points and track the minimum range.

**Algorithm:**
1. Sort nums.
2. Initial answer = nums[n-1] - nums[0] (all +k or all -k gives same range).
3. For each split i from 0..n-2: max = max(nums[i]+k, nums[n-1]-k), min = min(nums[0]+k, nums[i+1]-k). Update answer.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
