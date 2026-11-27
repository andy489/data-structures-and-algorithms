# 1641. Count Sorted Vowel Strings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-sorted-vowel-strings/

---

## Solution: Stars and Bars (Combinatorics) — O(1) time, O(1) space

**Idea:** Choosing a non-decreasing sequence of length `n` from 5 vowels is equivalent to choosing a multiset of size `n` from 5 elements, which equals C(n + 4, 4).

Alternatively, solve with DP: `dp[i][v]` = number of sorted strings of length `i` ending with vowel `v`. Each cell sums the counts for vowels `>= v` from the previous row.

**Algorithm (DP):**
- `dp[v]` = how many strings of current length end with the `v`-th vowel (0-indexed).
- Each step: `dp[v] += dp[v+1] + dp[v+2] + ... + dp[4]` from the previous iteration.
- After `n` steps, return `sum(dp)`.

**Closed form:** C(n + 4, 4) = (n+1)(n+2)(n+3)(n+4) / 24

**Complexity:**

| | |
|---|---|
| Time | O(n) DP or O(1) closed form |
| Space | O(1) |
