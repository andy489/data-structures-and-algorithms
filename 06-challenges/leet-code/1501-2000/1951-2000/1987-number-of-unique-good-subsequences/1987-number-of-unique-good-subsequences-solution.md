# 1987. Number of Unique Good Subsequences — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-unique-good-subsequences/

---

## Solution: DP — O(n) time, O(1) space

**Idea:** Track two DP values: `ends1` = number of unique good subsequences ending with `'1'`, `ends0` = number of unique good subsequences ending with `'0'` (non-empty, no leading zero). A good subsequence can only start with `'1'` or be `"0"`.

**Algorithm:**
1. For each character in `binary`:
   - If `'1'`: `ends1 = (ends1 + ends0 + 1) % MOD` (append 1 to all existing, or start new "1").
   - If `'0'`: `ends0 = (ends0 + ends1) % MOD` (append 0 to all subsequences ending in 1).
2. If `binary` contains `'0'`, add 1 for the standalone `"0"` subsequence.
3. Return `(ends1 + ends0 + hasZero) % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
