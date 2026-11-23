# 322. Coin Change — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/coin-change/

---

## Solution: Bottom-Up DP — O(amount * n) time, O(amount) space

**Idea:** `dp[i]` = minimum coins to make amount `i`. For each amount from 1 to `amount`, try every coin and take the minimum.

**Algorithm:**
1. Initialize `dp[0] = 0`, `dp[1..amount] = amount+1` (infinity sentinel).
2. For each `i` from 1 to `amount`, for each coin `c`: `dp[i] = min(dp[i], dp[i-c] + 1)` if `i >= c`.
3. Return `dp[amount]` if `< amount+1`, else `-1`.

**Complexity:**

| | |
|---|---|
| Time | O(amount * n) |
| Space | O(amount) |
