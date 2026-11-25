# 873. Length of Longest Fibonacci Subsequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

---

## Solution: DP with HashSet — O(n^2) time, O(n) space

**Idea:** For each pair (arr[i], arr[j]) as the last two elements, try to extend backwards. dp[i][j] = length of longest Fib ending at arr[i], arr[j]. dp[i][j] = dp[k][i] + 1 where arr[k] = arr[j] - arr[i].

**Algorithm:**
1. Put all elements in a set for O(1) lookup.
2. For each pair (j, i) with j < i: check if arr[j] - arr[i] exists and is < arr[j]. Update dp.
3. Track max dp value.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n^2) — dp table |
