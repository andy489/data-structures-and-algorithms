# 1696. Jump Game VI — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/jump-game-vi/

---

## Solution: DP with Monotonic Deque — O(n) time, O(k) space

**Idea:** `dp[i]` = maximum score to reach index `i`. It equals `nums[i] + max(dp[i-k..i-1])`. Use a monotonic deque (decreasing) to maintain the maximum over the sliding window of size `k`.

**Algorithm:**
1. Initialize `dp[0] = nums[0]`, deque = [0].
2. For `i` from 1 to `n-1`:
   - Remove indices outside window from front.
   - `dp[i] = nums[i] + dp[deque.front()]`.
   - Remove indices from back while `dp[deque.back()] <= dp[i]`.
   - Add `i` to deque.
3. Return `dp[n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(k) — deque size |
