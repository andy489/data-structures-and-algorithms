# 29. Divide Two Integers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/divide-two-integers/

---

## Solution: Bit Shifting (Exponential Search) — O(log² n) time, O(1) space

**Idea:** Work with `long` to avoid overflow. Convert both operands to their absolute values and determine the sign separately. To find how many times `divisor` fits into `dividend`, repeatedly double the divisor (left-shift by 1) until it would exceed the remaining dividend, accumulate the corresponding power-of-two count, subtract, and repeat. This is faster than linear subtraction because each outer iteration roughly halves the remaining dividend.

**Algorithm:**
1. Handle the single overflow case: `dividend == INT_MIN && divisor == -1` → return `INT_MAX`.
2. Compute `sign = (dividend > 0) == (divisor > 0) ? 1 : -1`.
3. Work with `a = |dividend|`, `b = |divisor|` as `long`.
4. While `a >= b`:
   - Find the largest `k` such that `b << k <= a`.
   - Add `1 << k` to the quotient and subtract `b << k` from `a`.
5. Return `sign * quotient`.

**Complexity:**

| | |
|---|---|
| Time  | O(log² n) — outer loop runs O(log n) times, inner doubling also O(log n) |
| Space | O(1) — only a constant number of variables |
