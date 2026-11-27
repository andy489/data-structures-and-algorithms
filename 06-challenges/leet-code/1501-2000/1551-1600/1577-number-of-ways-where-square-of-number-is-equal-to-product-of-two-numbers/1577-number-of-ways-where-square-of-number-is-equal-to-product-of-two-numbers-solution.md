# 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/

---

## Solution: HashMap Count — O(m + n) time, O(m + n) space

**Idea:** For each element `x` in array `a`, we need pairs `(j, k)` from array `b` such that `x^2 == b[j] * b[k]`. Build a frequency map of `b`. For each `x`, iterate over all distinct values `bv` in `b`; if `x^2 % bv == 0`, the needed partner is `x^2 / bv`. Use frequency counts to count unordered pairs, dividing by 2 at the end to avoid double-counting.

**Algorithm:**
1. For each direction (`a` vs `b` and `b` vs `a`), build frequency map of the second array.
2. For each `x` in the first array and each `bv` in the map, check if `x^2 / bv` exists.
3. Accumulate pair counts (handle the case where `bv == pair` to avoid double-counting same values).
4. Return total / 2 per direction, sum both.

**Complexity:**

| | |
|---|---|
| Time | O(m * d + n * d) — where d is number of distinct values in each array |
| Space | O(m + n) — frequency maps |
