# 537. Complex Number Multiplication — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/complex-number-multiplication/

---

## Solution: Parse and Multiply — O(1) time, O(1) space

**Idea:** Parse `a+bi` and `c+di` from the strings, then apply the formula:
`(a+bi)(c+di) = (ac - bd) + (ad + bc)i`

Since `i² = -1`, the real part is `ac - bd` and imaginary part is `ad + bc`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed-size parsing |
| Space | O(1) |
