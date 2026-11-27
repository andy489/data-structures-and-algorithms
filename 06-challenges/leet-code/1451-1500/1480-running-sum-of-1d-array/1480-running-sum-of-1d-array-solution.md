# 1480. Running Sum Of 1d Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/running-sum-of-1d-array/

---

## Solution: Prefix Sum — O(n) time, O(1) space

**Idea:** Accumulate prefix sum in-place.

**Algorithm:**
1. For i from 1 to n-1: nums[i] += nums[i-1]. Return nums.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
