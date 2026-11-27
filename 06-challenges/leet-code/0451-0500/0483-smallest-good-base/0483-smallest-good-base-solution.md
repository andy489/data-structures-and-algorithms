# 483. Smallest Good Base — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-good-base/

---

## Solution: Math + Binary Search — O(log²N) time, O(1) space

**Idea:** If n in base k = `1+k+k²+...+k^(m-1)` = `(k^m - 1)/(k-1)`, then for a given number of digits `m`, we can binary search for `k`. Max m is `log2(n)` since `2^m - 1 <= n`. Try m from largest to smallest; first found k >= 2 is smallest.

**Algorithm:**
1. For m from `floor(log2(n))` down to 2:
   - Binary search k in [2, n^(1/(m-1))].
   - Check if `1+k+...+k^(m-1) == n`.
   - If yes, return k.
2. Fallback: k = n-1 (always works since n = 1*(n-1) + 1 = 11 in base n-1).

**Complexity:**

| | |
|---|---|
| Time | O(log²N) — O(log N) values of m, each O(log N) binary search |
| Space | O(1) |
