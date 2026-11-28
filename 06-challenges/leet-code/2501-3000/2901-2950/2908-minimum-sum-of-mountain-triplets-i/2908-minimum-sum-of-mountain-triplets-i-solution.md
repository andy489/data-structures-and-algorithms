# 2908. Minimum Sum of Mountain Triplets I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/

---

## Solution: Brute Force — O(n^3) time, O(1) space

**Idea:** Given the small constraints (n <= 50), enumerate all triplets and check the mountain condition.

**Algorithm:**
1. Iterate over all triples `(i, j, k)` with `i < j < k`.
2. If `nums[i] < nums[j]` and `nums[k] < nums[j]`, track the minimum sum.
3. Return the minimum sum found, or `-1` if none.

**Complexity:**

| | |
|---|---|
| Time | O(n^3) |
| Space | O(1) |
