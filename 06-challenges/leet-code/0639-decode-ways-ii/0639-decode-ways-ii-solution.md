# 639. Decode Ways II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/decode-ways-ii/

---

## Solution: DP — O(n) time, O(1) space

**Idea:** Let `dp[i]` = ways to decode s[0..i-1]. Track `prev2` (dp[i-2]) and `prev1` (dp[i-1]). For each character, count one-digit ways (via `prev1`) and two-digit ways (via `prev2`) by enumerating '*' possibilities.

**Algorithm:**
1. Single-digit: '*' → 9 ways; '0' → 0; else 1.
2. Two-digit (with prev char): depends on whether each is '*' or digit.
3. `dp[i] = single * prev1 + double * prev2`, mod 10^9+7.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — two variables |
