# 1406. Stone Game Iii — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stone-game-iii/

---

## Solution: DP from Right — O(n) time, O(1) space

**Idea:** dp[i] = max score the current player can get from index i onward. Scan right to left keeping only last 3 values.

**Algorithm:**
1. dp[n] = 0. For i from n-1 to 0:
2. dp[i] = max over k=1,2,3 of (sum(stoneValue[i..i+k-1]) - dp[i+k]).
3. Compare dp[0] vs totalSum - dp[0].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
