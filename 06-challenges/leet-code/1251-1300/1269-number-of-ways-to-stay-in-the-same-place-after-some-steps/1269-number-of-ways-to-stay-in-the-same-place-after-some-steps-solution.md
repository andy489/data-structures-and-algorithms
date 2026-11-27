# 1269. Number of Ways to Stay in the Same Place After Some Steps — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/

---

## Solution: Dynamic Programming — O(steps * min(steps, arrLen)) time, O(steps * min(steps, arrLen)) space

**Idea:** dp[i][j] = number of ways to be at position j after i steps. The farthest we can reach is min(steps//2, arrLen-1).

**Algorithm:**
1. Limit effective arrLen to min(steps//2+1, arrLen).
2. dp[0][0]=1, transitions: stay, go left, go right.
3. Return dp[steps][0].

**Complexity:**

| | |
|---|---|
| Time | O(steps * min(steps, arrLen)) |
| Space | O(steps * min(steps, arrLen)) |
