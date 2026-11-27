# 1745. Palindrome Partitioning IV — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/palindrome-partitioning-iv/

---

## Solution: DP Palindrome Table — O(n²) time, O(n²) space

**Idea:** Precompute a boolean table `isPalin[i][j]` indicating whether `s[i..j]` is a palindrome using DP (expand from center or bottom-up DP). Then iterate over all split points `(i, j)` with `i < j` and check if `isPalin[0][i-1]`, `isPalin[i][j]`, and `isPalin[j+1][n-1]` are all true.

**Algorithm:**
1. Build `isPalin[i][j]` bottom-up: single chars are palindromes; for length ≥ 2, `isPalin[i][j] = s[i]==s[j] && isPalin[i+1][j-1]`.
2. For every pair `(i, j)` with `1 <= i <= j <= n-2`, check all three parts.
3. Return true as soon as one valid split is found.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — building the DP table and iterating splits |
| Space | O(n²) — palindrome DP table |
