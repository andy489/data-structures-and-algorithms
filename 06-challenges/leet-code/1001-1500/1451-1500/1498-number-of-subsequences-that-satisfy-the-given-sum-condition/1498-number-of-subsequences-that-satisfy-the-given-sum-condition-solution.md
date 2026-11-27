# 1498. Number Of Subsequences That Satisfy The Given Sum Condition — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

---

## Solution: Sort + Two Pointers + Precomputed Powers — O(n log n) time, O(n) space

**Idea:** Sort. For each left pointer, binary search for rightmost element such that nums[left]+nums[right]<=target. Count = 2^(right-left).

**Algorithm:**
1. Sort nums. Precompute pow2[i] = 2^i mod MOD.
2. Two pointers l=0, r=n-1. While l <= r: if nums[l]+nums[r] <= target, add 2^(r-l), l++. Else r--.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
