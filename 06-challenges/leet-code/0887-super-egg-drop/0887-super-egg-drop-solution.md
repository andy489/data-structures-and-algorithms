# 887. Super Egg Drop — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/super-egg-drop/

---

## Solution: DP (Inverse) — O(k * n) time, O(k) space

**Idea:** Instead of "minimum moves to cover n floors with k eggs", ask "maximum floors we can check with t moves and k eggs". f(t, k) = f(t-1, k-1) + f(t-1, k) + 1 (break + no-break + current). Find smallest t where f(t, k) >= n.

**Algorithm:**
1. dp[j] = max floors testable with t moves and j eggs.
2. For t=1,2,...: update dp. When dp[k] >= n, return t.

**Complexity:**

| | |
|---|---|
| Time | O(k * n) |
| Space | O(k) |
