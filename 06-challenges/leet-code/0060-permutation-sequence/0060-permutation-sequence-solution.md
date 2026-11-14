# 60. Permutation Sequence — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/permutation-sequence/

---

## Solution: Factorial Number System — O(n^2) time, O(n) space

**Idea:** There are `(n-1)!` permutations starting with each digit. Convert `k` to 0-indexed, then for each position greedily pick the digit at index `k / (n-1)!`, remove it from the available list, and update `k %= (n-1)!`. Repeat for all `n` positions.

**Algorithm:**
1. Build `digits = [1, 2, ..., n]` and precompute factorials `fact[0..n]`.
2. Decrement `k` to make it 0-indexed.
3. For `i` from `n-1` down to `0`:
   - Pick `idx = k / fact[i]`, append `digits[idx]` to result.
   - Remove `digits[idx]`, set `k %= fact[i]`.
4. Return the built string.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — n iterations, each removes from a list in O(n) |
| Space | O(n) — digits list and result |
