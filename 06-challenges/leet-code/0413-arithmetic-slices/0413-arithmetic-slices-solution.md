# 413. Arithmetic Slices — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/arithmetic-slices/

---

## Solution: Dynamic Programming — O(n) time, O(1) space

**Idea:** Let `dp[i]` = number of arithmetic slices ending at index `i`. If `nums[i] - nums[i-1] == nums[i-1] - nums[i-2]`, then `dp[i] = dp[i-1] + 1`, since every existing slice ending at `i-1` can be extended by one element. The answer is the sum of all `dp[i]`.

Since we only need the previous `dp` value, we use a single variable `curr` instead of an array.

**Algorithm:**
1. Initialize `curr = 0`, `total = 0`.
2. For each `i` from 2 to `n-1`: if the last two differences are equal, increment `curr` and add it to `total`; else reset `curr = 0`.
3. Return `total`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only two variables |
