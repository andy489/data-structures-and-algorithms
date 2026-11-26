# 472. Concatenated Words — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/concatenated-words/

---

## Solution: DP with WordSet — O(N · L²) time, O(N · L) space

**Idea:** Sort words by length. For each word, check if it can be split into two or more shorter words already in the set using DP. Only add each word to the set after checking (so it can't use itself).

**Algorithm:**
1. Sort words by length ascending; build a HashSet.
2. For each word, run DP: `dp[i]` = true if `word[0..i-1]` can be formed from words in set.
3. The word is concatenated if any `dp[j]` is true for `j < len` and `dp[len]` is also true.

**Complexity:**

| | |
|---|---|
| Time | O(N · L²) — N words, each checked in O(L²) DP |
| Space | O(N · L) — word set storage |
