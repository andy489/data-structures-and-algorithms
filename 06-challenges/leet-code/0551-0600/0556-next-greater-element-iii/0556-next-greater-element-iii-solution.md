# 556. Next Greater Element III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/next-greater-element-iii/

---

## Solution: Next Permutation — O(d) time, O(d) space (d = number of digits)

**Idea:** Apply next-permutation algorithm on the digits of `n`. If no next permutation exists or result overflows int, return -1.

**Algorithm:**
1. Convert `n` to char array of digits.
2. Find largest index `i` such that `digits[i] < digits[i+1]` (from right).
3. If none, return -1.
4. Find largest index `j > i` such that `digits[j] > digits[i]`.
5. Swap `digits[i]` and `digits[j]`.
6. Reverse suffix `digits[i+1..]`.
7. Parse result as long; if > Integer.MAX_VALUE, return -1.

**Complexity:**

| | |
|---|---|
| Time | O(d) — d ≤ 10 digits |
| Space | O(d) — digit array |
