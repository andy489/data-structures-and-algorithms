# 91. Decode Ways — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/decode-ways/

---

## Solution: 1D DP (Space-Optimized) — O(n) time, O(1) space

**Idea:** Let `dp[i]` = number of ways to decode `s[0..i-1]`. At each position we check:
- **Single-digit decode:** if `s[i-1] != '0'`, add `dp[i-1]` (the current digit forms a valid letter).
- **Two-digit decode:** if `s[i-2..i-1]` is between `"10"` and `"26"`, add `dp[i-2]`.

We only ever need the previous two values, so two variables replace the full array.

**Algorithm:**
1. If `s[0] == '0'`, return `0` immediately.
2. Initialize `prev2 = 1` (empty prefix), `prev1 = 1` (first character, already validated).
3. For `i` from `2` to `n`:
   - `curr = 0`
   - If `s[i-1] != '0'`: `curr += prev1`
   - Let `two = (s[i-2] - '0') * 10 + (s[i-1] - '0')`; if `10 <= two <= 26`: `curr += prev2`
   - Advance: `prev2 = prev1`, `prev1 = curr`
4. Return `prev1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — two scalar variables |
