# 2903. Find Indices With Index and Value Difference I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/

---

## Solution: Brute Force — O(n^2) time, O(1) space

**Idea:** Given the small constraints (n <= 100), we can try all pairs (i, j) and check both conditions directly.

**Algorithm:**
1. Iterate over all pairs `(i, j)` where both are in `[0, n-1]`.
2. If `abs(i - j) >= indexDifference` and `abs(nums[i] - nums[j]) >= valueDifference`, return `[i, j]`.
3. If no pair found, return `[-1, -1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(1) |
