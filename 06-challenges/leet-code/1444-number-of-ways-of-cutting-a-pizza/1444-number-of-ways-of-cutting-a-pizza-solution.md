# 1444. Number Of Ways Of Cutting A Pizza — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

---

## Solution: DP + Prefix Sum — O(k * rows * cols * (rows+cols)) time, O(k * rows * cols) space

**Idea:** dp[r][c][rem] = number of ways to cut remaining pizza starting at (r,c) into rem pieces. Use 2D prefix sums to quickly count apples.

**Algorithm:**
1. Precompute suffix apple counts.
2. dp[r][c][1] = 1 if any apple in pizza[r:][c:], else 0.
3. dp[r][c][k] = sum over all horizontal cuts (r' in r+1..rows-1) where top part has apple + dp[r'][c][k-1]; plus vertical cuts.
4. Return dp[0][0][k].

**Complexity:**

| | |
|---|---|
| Time | O(k * rows * cols * (rows+cols)) |
| Space | O(k * rows * cols) |
