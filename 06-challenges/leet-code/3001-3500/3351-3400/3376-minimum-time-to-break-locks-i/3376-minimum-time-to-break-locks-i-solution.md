# 3376. Minimum Time to Break Locks I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-time-to-break-locks-i/

---

## Solution: Bitmask DP — O(2^n · n) time, O(2^n) space

**Idea:** Since n ≤ 8, we use bitmask DP. The j-th lock broken (0-indexed, counting set bits in the mask) uses factor `x = 1 + j * k`. The time to break a lock of strength `s` with factor `x` is `ceil(s / x)`. State: `dp[mask]` = minimum total time to break exactly the locks indicated by `mask`.

**Algorithm:**
1. Initialise `dp[0] = 0`, all others to `+∞`.
2. For each mask from 0 to `2^n - 1`:
   - Let `j = popcount(mask)` (number of locks already broken).
   - Factor `x = 1 + j * k`.
   - For each bit `i` not in mask: `dp[mask | (1<<i)] = min(..., dp[mask] + ceil(strength[i] / x))`.
3. Return `dp[(1<<n) - 1]`.

**Complexity:**

| | |
|---|---|
| Time | O(2^n · n) — 2^8 · 8 = 2048 states/transitions |
| Space | O(2^n) — DP table |
