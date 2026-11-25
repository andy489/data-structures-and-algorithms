# 730. Count Different Palindromic Subsequences — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-different-palindromic-subsequences/

---

## Solution: Interval DP — O(n² · |alphabet|) time, O(n²) space

**Idea:** `dp[i][j]` = number of distinct palindromic subsequences in `s[i..j]`. For each pair (i, j), consider each character c ∈ {a,b,c,d}. Find the leftmost `l` and rightmost `r` occurrence of c in [i, j]. Based on relative positions, add 1, 2, or `dp[l+1][r-1] + 2` to dp[i][j].

**Algorithm:**
1. For length 1..n, for each [i, j]:
   - For each char c in {a,b,c,d}: find l = first c in [i,j], r = last c in [i,j].
   - If l == r: add 1 (single char palindrome).
   - If l + 1 == r: add 2 (c and cc).
   - If l < r: add dp[l+1][r-1] + 2.
2. Take all sums mod 10^9+7.

**Complexity:**

| | |
|---|---|
| Time | O(n² · 4) = O(n²) |
| Space | O(n²) |
