# 1755. Closest Subsequence Sum — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/closest-subsequence-sum/

---

## Solution: Meet in the Middle — O(2^(n/2) · n) time, O(2^(n/2)) space

**Idea:** With n up to 40, brute force (2^40) is too slow. Split into two halves of ~20 elements each. Enumerate all 2^20 subset sums for each half. For each sum `s` in the left half, binary search the sorted right-half sums for the value closest to `goal - s`.

**Algorithm:**
1. Split `nums` into `left` and `right`.
2. Generate all 2^|left| subset sums for left → `leftSums`.
3. Generate all 2^|right| subset sums for right → `rightSums`, sort it.
4. For each `s` in `leftSums`, binary search `rightSums` for the value closest to `goal - s`; track minimum `|s + found - goal|`.
5. Return the minimum.

**Complexity:**

| | |
|---|---|
| Time | O(2^(n/2) · log(2^(n/2))) = O(2^(n/2) · n) |
| Space | O(2^(n/2)) — subset sum arrays |
