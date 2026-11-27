# 171. Excel Sheet Column Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/excel-sheet-column-number/

---

## Solution: Base-26 Conversion — O(n) time, O(1) space

**Idea:** This is a base-26 positional number system where A=1, B=2, …, Z=26 (no zero digit). Process the string left to right: multiply the running result by 26 (shift left one base-26 digit) and add the current letter's value. This is equivalent to evaluating the polynomial `c₀ × 26^(n-1) + c₁ × 26^(n-2) + … + cₙ₋₁ × 26^0` using Horner's method.

**Algorithm:**
1. Initialise `result = 0`.
2. For each character `c` in `columnTitle`:
   - `result = result * 26 + (c - 'A' + 1)`.
3. Return `result`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single left-to-right pass; n ≤ 7 so effectively O(1) |
| Space | O(1) — no extra storage |
