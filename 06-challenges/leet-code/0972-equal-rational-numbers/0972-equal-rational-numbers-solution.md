# 972. Equal Rational Numbers — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/equal-rational-numbers/

---

## Solution: Convert to Fraction — O(1) time, O(1) space

**Idea:** Convert each rational string to a fraction (p/q), reduce by GCD, and compare.

**Algorithm:**
1. Parse integer part, non-repeating decimal, repeating part.
2. Use fraction arithmetic: repeating `d` of length `k` = `d / (10^k - 1)`.
3. Combine all parts into one fraction and reduce.

**Complexity:**

| | |
|---|---|
| Time | O(1) — bounded by input length constraints |
| Space | O(1) |
