# 131. Palindrome Partitioning — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/palindrome-partitioning/

---

## Solution 1: Backtracking — O(n · 2ⁿ) time, O(n²) space

**Idea:** At each position, try every suffix that is a palindrome, add it to the current path, recurse on the remainder, then backtrack. When the start index reaches the end of the string, record the current path.

**Algorithm:**
1. Define `backtrack(start, path)`.
2. If `start == n`, add a copy of `path` to results and return.
3. For each `end` from `start` to `n-1`: if `s[start..end]` is a palindrome, push it onto `path`, recurse with `start = end + 1`, then pop.
4. Palindrome check is O(n) inline.

**Complexity:**

| | |
|---|---|
| Time  | O(n · 2ⁿ) — up to 2ⁿ partitions, each copy is O(n) |
| Space | O(n) recursion depth + O(n²) result storage |

---

## Solution 2: Backtracking + DP Palindrome Table — O(n · 2ⁿ) time, O(n²) space

**Idea:** Pre-compute a 2-D boolean table `dp[i][j]` (true if `s[i..j]` is a palindrome) in O(n²). This avoids re-scanning palindromes during backtracking, cutting constant factors significantly on inputs with many repeated characters.

**Algorithm:**
1. Fill `dp`: `dp[i][i] = true`; `dp[i][i+1] = (s[i] == s[i+1])`; for length ≥ 3: `dp[i][j] = (s[i] == s[j]) && dp[i+1][j-1]`.
2. Run the same backtracking as Solution 1, but check `dp[start][end]` in O(1) instead of scanning.

**Complexity:**

| | |
|---|---|
| Time  | O(n²) pre-computation + O(n · 2ⁿ) backtracking |
| Space | O(n²) DP table |
