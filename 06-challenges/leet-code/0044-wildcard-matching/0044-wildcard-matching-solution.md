# 44. Wildcard Matching — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/wildcard-matching/

---

## Solution: 2D DP — O(m·n) time, O(m·n) space

**Idea:** `dp[i][j]` = true if `s[0..i-1]` matches `p[0..j-1]`. Base case: `dp[0][0] = true` (empty matches empty). A leading `*` in the pattern can match the empty string, so `dp[0][j] = dp[0][j-1]` when `p[j-1] == '*'`.

**Transitions:**
- `p[j-1] == s[i-1]` or `p[j-1] == '?'`: `dp[i][j] = dp[i-1][j-1]`
- `p[j-1] == '*'`: `dp[i][j] = dp[i-1][j]` (star consumes one char) `|| dp[i][j-1]` (star matches empty)

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — m = `s.length`, n = `p.length` |
| Space | O(m·n) — 2D table |

---

## Solution 2: Greedy with backtracking — O(m·n) worst case, O(1) space

**Idea:** Walk `s` and `p` together with two pointers `i`, `j`. When we hit `*`, record the star position (`starJ`) and the current string position (`matchI`). If later there's a mismatch, backtrack: advance `matchI` by one (star matches one more char) and reset `j = starJ + 1`.

**Algorithm:**
1. `i = j = 0`, `starJ = -1`, `matchI = 0`.
2. While `i < m`: if `j < n` and (`p[j] == s[i]` or `p[j] == '?'`): advance both. Else if `j < n && p[j] == '*'`: save `starJ = j`, `matchI = i`, advance `j`. Else if `starJ != -1`: `j = starJ + 1`, `matchI++`, `i = matchI`. Else return false.
3. Skip trailing `*`s in `p`. Return `j == n`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) worst case, O(m+n) average |
| Space | O(1) |

---

## Solution 3: NFA simulation — O(m·n) time, O(n) space

**Idea:** Model the pattern as an NFA where each position in `p` is a state. A literal or `?` consumes one input character (read transition). A `*` adds an epsilon transition to the next state (match empty) and implicitly loops on any character (handled by keeping the `*` state active while reading). Simulate by tracking the current *set* of active states and advancing it character by character through `s`.

**Algorithm:**
1. Start with `cur = {0}`, epsilon-closed: while the current frontier contains a `*` state, also add state+1 (star matches empty).
2. For each character `s[i]`: build `next` by advancing every state in `cur` that matches `s[i]` (literal match or `?`). Epsilon-close `next`.
3. Accept if state `n` ∈ `cur` after consuming all of `s`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — m chars × up to n active states |
| Space | O(n) — two state sets of size ≤ n |
