# 3010. Divide an Array Into Subarrays With Minimum Cost I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/

---

## Solution: Greedy (Two Smallest) — O(n) time, O(1) space

**Idea:** The first subarray always starts at index 0 (cost = nums[0]). The second and third subarrays start at some indices i < j. Their costs are nums[i] + nums[j]. To minimize, we want the two smallest values from nums[1..n-1].

**Algorithm:**
1. Take nums[0] as fixed cost.
2. Find the two smallest values in nums[1..n-1].
3. Return nums[0] + min1 + min2.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
