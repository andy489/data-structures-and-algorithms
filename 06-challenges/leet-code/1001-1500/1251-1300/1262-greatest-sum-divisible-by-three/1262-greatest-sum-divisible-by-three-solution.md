# 1262. Greatest Sum Divisible by Three — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/greatest-sum-divisible-by-three/

---

## Solution: Dynamic Programming — O(n) time, O(1) space

**Idea:** dp[r] = max sum with remainder r. For each number, update dp values based on current remainders.

**Algorithm:**
1. dp = [0, -inf, -inf] (max sum for remainders 0,1,2).
2. For each x: new_dp[r] = max(dp[r], dp[(r-x%3+3)%3] + x).
3. Return dp[0].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
