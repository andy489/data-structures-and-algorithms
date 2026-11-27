# 793. Preimage Size of Factorial Zeroes Function — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/

---

## Solution: Binary Search — O(log² k) time, O(1) space

**Idea:** `f(x)` = trailing zeroes of `x!` = floor(x/5) + floor(x/25) + ... The answer is either 0 or 5. Count how many x have f(x) ≤ k minus how many have f(x) ≤ k-1 using binary search on a monotone function.

**Algorithm:**
1. `leftBound(k)` = smallest x with `trailingZeroes(x) > k` using binary search.
2. Answer = `leftBound(k) - leftBound(k-1)`.
3. `trailingZeroes(x)` = sum of floor(x/5^i).

**Complexity:**

| | |
|---|---|
| Time | O(log² k) — two binary searches, each O(log k) with O(log k) trailing zeroes computation |
| Space | O(1) |
