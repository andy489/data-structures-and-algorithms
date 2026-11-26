# 1278. Palindrome Partitioning III — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/palindrome-partitioning-iii/

---

## Solution: Dynamic Programming — O(n^2 * k) time, O(n^2) space

**Idea:** cost[i][j] = min changes to make s[i..j] a palindrome. dp[i][j] = min changes to partition s[0..i] into j palindromes.

**Algorithm:**
1. Precompute cost[i][j].
2. dp[i][j] = min over all splits: dp[m][j-1] + cost[m+1][i].
3. Return dp[n-1][k].

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * k) |
| Space | O(n^2) |
