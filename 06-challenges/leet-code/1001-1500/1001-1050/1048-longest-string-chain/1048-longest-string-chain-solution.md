# 1048. Longest String Chain — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-string-chain/

---

## Solution: DP with Word Predecessors — O(n * L²) time, O(n * L) space

**Idea:** Sort words by length. For each word, try removing each character to get a predecessor; `dp[word] = max(dp[predecessor] + 1)`.

**Algorithm:**
1. Sort words by length.
2. For each word w: for each i, form candidate = w without char i. If candidate in dp, `dp[w] = max(dp[w], dp[candidate]+1)`.
3. Return max dp value.

**Complexity:**

| | |
|---|---|
| Time | O(n * L²) |
| Space | O(n * L) |
