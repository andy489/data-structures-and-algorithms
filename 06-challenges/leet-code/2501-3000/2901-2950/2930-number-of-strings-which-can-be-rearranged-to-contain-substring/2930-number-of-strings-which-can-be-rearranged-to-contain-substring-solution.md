# 2930. Number of Strings Which Can Be Rearranged to Contain Substring — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-strings-which-can-be-rearranged-to-contain-substring/

---

## Solution: Inclusion-Exclusion on Character Counts — O(n) time, O(1) space

**Idea:** A string of length `n` is good if it has at least 1 `l`, at least 2 `e`s, and at least 1 `t` (the requirements of "leet"). Use inclusion-exclusion to count the complement (strings missing at least one requirement) and subtract from the total `26^n`.

Let:
- `A` = strings with 0 `l`s → `25^n`
- `B` = strings with 0 or 1 `e`s → `25^n + n * 25^(n-1)`
- `C` = strings with 0 `t`s → `25^n`

By inclusion-exclusion: bad = |A ∪ B ∪ C| = |A| + |B| + |C| - |A∩B| - |A∩C| - |B∩C| + |A∩B∩C|.

**Algorithm:**
1. Compute each term of inclusion-exclusion using fast modular exponentiation.
2. Return `(26^n - bad + MOD) % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
