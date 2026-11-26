# 1726. Tuple with Same Product — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/tuple-with-same-product/

---

## Solution: Hash Map of Products — O(n^2) time, O(n^2) space

**Idea:** Count how many pairs `(i, j)` produce each product. For every product appearing `c` times, the number of ways to pick 2 pairs is `C(c,2) = c*(c-1)/2`, and each such pair of pairs generates 8 valid tuples (due to permutations of a,b and c,d and swapping the two pairs).

**Algorithm:**
1. Enumerate all pairs `(i, j)` with `i < j`; store product frequency in a map.
2. For each product with count `c`, add `c * (c - 1) / 2 * 8` to the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — all pairs |
| Space | O(n^2) — map entries |
