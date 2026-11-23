# 368. Largest Divisible Subset — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-divisible-subset/

---

## Solution: Sort + DP — O(n²) time, O(n) space

**Idea:** Sort the array. For each element, the longest divisible subset ending at it is 1 + the longest subset ending at any smaller element that divides it. Track parent indices to reconstruct the path.

**Algorithm:**
1. Sort `nums`.
2. `dp[i]` = length of largest divisible subset ending at `nums[i]`.
3. `parent[i]` = index of previous element in the subset.
4. For each `i`, scan `j < i`; if `nums[i] % nums[j] == 0` and `dp[j] + 1 > dp[i]`, update.
5. Reconstruct subset from the index of maximum `dp` value.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n) — dp and parent arrays |
