# 140. Word Break II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/word-break-ii/

---

## Solution 1: Memoized DFS (Top-Down) — O(n · 2ⁿ) time, O(n · 2ⁿ) space

**Idea:** Recursively try every prefix of the remaining string; if it is in the dictionary, recurse on the suffix and prepend the word to each sentence returned. Memoize results keyed by start index to avoid re-exploring the same suffix.

**Algorithm:**
1. Put `wordDict` in a set.
2. `dfs(start)` returns all sentences for `s[start..]`. If cached, return immediately.
3. If `start == n`, return `[""]` (empty sentence base case).
4. For each `end` from `start+1` to `n`: if `s[start..end-1]` is in the dict, recurse on `dfs(end)` and prepend the word (with a space separator) to each result.
5. Cache and return the list.

**Complexity:**

| | |
|---|---|
| Time  | O(n · 2ⁿ) — bounded by number of partitions × string work |
| Space | O(n · 2ⁿ) — memo stores all sentences |

---

## Solution 2: Bottom-Up DP — O(n · 2ⁿ) time, O(n · 2ⁿ) space

**Idea:** Build `dp[i]` = list of all sentences for `s[0..i-1]`. For each position, check every word that ends at `i`; if `dp[i - len]` is non-empty (or `i == len`), extend those sentences with the new word.

**Algorithm:**
1. `dp[0] = [""]` (empty prefix → one empty sentence).
2. For `i` from 1 to `n`: for each word `w` of length `len`: if `i >= len`, `s[i-len..i-1] == w`, and `dp[i-len]` is non-empty: append `(prev + " " + w).strip()` to `dp[i]`.
3. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time  | O(n · 2ⁿ) — same worst-case as top-down |
| Space | O(n · 2ⁿ) — dp arrays hold all sentences |
