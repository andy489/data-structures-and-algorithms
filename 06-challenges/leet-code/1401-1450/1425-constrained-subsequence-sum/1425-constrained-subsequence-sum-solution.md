# 1425. Constrained Subsequence Sum — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/constrained-subsequence-sum/

---

## Solution: Monotonic Deque DP — O(n) time, O(n) space

**Idea:** dp[i] = max sum of valid subsequence ending at i = nums[i] + max(0, max(dp[i-k..i-1])). Use a decreasing deque to track the max over the last k values.

**Algorithm:**
1. Deque stores indices with decreasing dp values.
2. dp[i] = nums[i] + max(0, dp[deque.front]) (if deque not empty).
3. Maintain deque: pop front if out of window (i - deque.front > k). Pop back while dp[back] <= dp[i].
4. Answer = max(dp).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
