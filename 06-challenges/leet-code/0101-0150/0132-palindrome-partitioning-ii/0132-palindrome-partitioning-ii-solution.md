# 132. Palindrome Partitioning II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/palindrome-partitioning-ii/

---

## Solution 1: DP + Expand-Around-Center — O(n²) time, O(n) space

**Idea:** Let `cut[i]` = minimum cuts for `s[0..i]`. For every palindrome centered at position `c` (both odd and even length), update `cut[j] = min(cut[j], cut[i-1] + 1)` where `s[i..j]` is that palindrome. Expanding from every center covers all palindromic substrings in O(n²) total and avoids building a full n×n table.

**Algorithm:**
1. Init `cut[i] = i` (worst case: cut before every character, i.e., `i` cuts for index `i`).
2. For each center `c` from `0` to `n-1`:
   - Expand odd-length palindromes: `s[c-k..c+k]`. If `i = c-k == 0`, set `cut[c+k] = 0` (whole prefix is palindrome); else `cut[c+k] = min(cut[c+k], cut[i-1] + 1)`.
   - Expand even-length palindromes: `s[c-k+1..c+k]` similarly.

**Complexity:**

| | |
|---|---|
| Time  | O(n²) — each center expands at most O(n) steps |
| Space | O(n) — only the `cut` array |

---

## Solution 2: DP + 2-D Palindrome Table — O(n²) time, O(n²) space

**Idea:** Pre-compute `isPalin[i][j]` for all pairs, then fill `cut[i]` using those values. Slightly more space but arguably cleaner separation of concerns.

**Algorithm:**
1. Build `isPalin[i][j]`: `dp[i][i] = true`; `dp[i][i+1] = (s[i]==s[i+1])`; for length ≥ 3: `dp[i][j] = (s[i]==s[j]) && dp[i+1][j-1]`.
2. `cut[i] = i` initially.
3. For each `i`: if `isPalin[0][i]`, set `cut[i] = 0`; else for each `j` from `1` to `i`: if `isPalin[j][i]`, `cut[i] = min(cut[i], cut[j-1] + 1)`.

**Complexity:**

| | |
|---|---|
| Time  | O(n²) — two separate O(n²) passes |
| Space | O(n²) — palindrome table |
