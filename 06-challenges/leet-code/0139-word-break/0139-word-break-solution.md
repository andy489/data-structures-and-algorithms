# 139. Word Break — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/word-break/

---

## Solution 1: Bottom-Up DP — O(n² · m) time, O(n) space

**Idea:** Let `dp[i]` mean `s[0..i-1]` can be segmented. `dp[0] = true` (empty prefix). For each position `i`, check every word in the dict: if `dp[i - word.length]` is true and `s` ends with `word` at position `i`, set `dp[i] = true`.

**Algorithm:**
1. Put all words in a set for O(1) lookup.
2. Init `dp[0] = true`, rest `false`.
3. For `i` from 1 to `n`: for each word `w`, if `i >= w.length` and `dp[i - w.length]` and `s[i-w.length..i-1] == w`, set `dp[i] = true`.
4. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time  | O(n² · m) — n positions × dict size × substring comparison |
| Space | O(n) — DP array |

---

## Solution 2: Top-Down Memoized DFS — O(n²) time, O(n) space

**Idea:** Recursively try every prefix of the remaining string; if a prefix is in the dict, recurse on the suffix. Cache results indexed by the start position to avoid redundant work.

**Algorithm:**
1. Put all words in a set.
2. `dfs(start)`: if `start == n` return `true`. If cached, return cache. Try every `end` from `start+1` to `n`; if `s[start..end-1]` is in the set and `dfs(end)` is `true`, cache and return `true`. Cache and return `false`.
3. Return `dfs(0)`.

**Complexity:**

| | |
|---|---|
| Time  | O(n²) — each of n start positions tries up to n substrings, each check O(n) with set → O(n²) total (string hashing O(n) per lookup) |
| Space | O(n) — memo array + recursion stack |
