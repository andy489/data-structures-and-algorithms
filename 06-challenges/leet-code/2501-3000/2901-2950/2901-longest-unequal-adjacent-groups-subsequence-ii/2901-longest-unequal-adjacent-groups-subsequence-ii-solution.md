# 2901. Longest Unequal Adjacent Groups Subsequence II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/

---

## Solution: Dynamic Programming (LIS variant) — O(n^2 * L) time, O(n) space

**Idea:** Use DP where `dp[i]` is the length of the longest valid subsequence ending at index `i`. For each `i`, look back at all `j < i` and check if `groups[j] != groups[i]`, words have equal length, and hamming distance is exactly 1. Track the previous index to reconstruct the path.

**Algorithm:**
1. Initialize `dp[i] = 1` and `prev[i] = -1` for all `i`.
2. For each `i` from 1 to n-1, iterate over each `j < i`.
3. If `groups[j] != groups[i]`, `words[j].length == words[i].length`, and hamming distance == 1, then update `dp[i] = max(dp[i], dp[j] + 1)` and `prev[i] = j`.
4. Find the index `best` with maximum `dp[best]`, then backtrack using `prev` to build the result.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * L) |
| Space | O(n) |
