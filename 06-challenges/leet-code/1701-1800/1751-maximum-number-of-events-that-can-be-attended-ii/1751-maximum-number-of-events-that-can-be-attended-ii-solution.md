# 1751. Maximum Number of Events That Can Be Attended II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/

---

## Solution: Sort + DP + Binary Search — O(n·k·log n) time, O(n·k) space

**Idea:** Sort events by end day. Define `dp[i][j]` as the max value attending at most `j` events from the first `i` events. For event `i` (1-indexed), either skip it (`dp[i-1][j]`) or take it: find the last event that ends before `events[i-1][0]` using binary search, then add `events[i-1][2]` to `dp[prev][j-1]`.

**Algorithm:**
1. Sort events by end day.
2. Build `dp[n+1][k+1]` table.
3. For each event `i` and count `j`, apply the recurrence using binary search on start day.
4. Return `dp[n][k]`.

**Complexity:**

| | |
|---|---|
| Time | O(n·k·log n) — n events × k counts × binary search |
| Space | O(n·k) — DP table |
