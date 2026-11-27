# 1830. Minimum Number of Operations to Make String Sorted — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/

---

## Solution: Factorial Rank — O(n * 26) time, O(n) space

**Idea:** Each operation is exactly the "previous permutation" step (the inverse of `next_permutation`). The number of operations equals the 0-indexed lexicographic rank of `s` among all permutations of its characters. The rank is computed position by position: for each position `i`, count how many characters smaller than `s[i]` remain in the suffix, multiply by the number of distinct permutations of the remaining suffix (accounting for duplicates using factorials and their modular inverses), and sum up.

**Algorithm:**
1. Precompute `fact[0..n]` and `invFact[0..n]` modular factorials and inverse factorials.
2. Count character frequencies `cnt[0..25]`.
3. For each position `i`:
   - Count `smaller` = sum of `cnt[j]` for `j < cur` (characters less than `s[i]`).
   - Compute `ways = fact[n-1-i] * product(invFact[cnt[j]])` for all 26 characters with current counts minus 1 at `cur`.
   - Add `smaller * ways` to answer.
   - Decrement `cnt[cur]`.
4. Return `ans mod 10^9+7`.

**Complexity:**

| | |
|---|---|
| Time | O(n * 26) — for each of n characters, iterate over 26 possible chars |
| Space | O(n) — factorial and inverse factorial arrays |
