# 1986. Minimum Number of Work Sessions to Finish the Tasks — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/

---

## Solution: Bitmask DP — O(2^n * n) time, O(2^n) space

**Idea:** Use bitmask DP where `dp[mask]` = minimum sessions to finish the subset of tasks represented by `mask`. Also track remaining time in current session via `rem[mask]`.

**Algorithm:**
1. `dp[0] = 0`, `rem[0] = sessionTime`.
2. For each `mask` and each unset bit `i`, try adding `tasks[i]`:
   - If it fits in current session: `dp[newMask] = dp[mask]`, `rem[newMask] = rem[mask] - tasks[i]`.
   - Else start new session: `dp[newMask] = dp[mask] + 1`, `rem[newMask] = sessionTime - tasks[i]`.
3. Return `dp[(1<<n) - 1]`.

**Complexity:**

| | |
|---|---|
| Time | O(2^n · n) |
| Space | O(2^n) |
