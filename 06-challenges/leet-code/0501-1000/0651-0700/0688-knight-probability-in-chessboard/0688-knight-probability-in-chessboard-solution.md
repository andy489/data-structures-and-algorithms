# 688. Knight Probability in Chessboard — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/knight-probability-in-chessboard/

---

## Solution: DP — O(k·n²) time, O(n²) space

**Idea:** `dp[r][c]` = probability of being at (r,c) after some steps. Each step, spread the probability to all valid knight moves, dividing by 8.

**Algorithm:**
1. Initialize `dp[row][col] = 1.0`.
2. For each of k steps: create new `dp2`; for each cell, distribute prob/8 to each valid move.
3. Sum all values in final dp.

**Complexity:**

| | |
|---|---|
| Time | O(k·n²) |
| Space | O(n²) |
