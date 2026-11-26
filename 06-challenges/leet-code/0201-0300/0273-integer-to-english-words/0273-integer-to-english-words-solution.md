# 273. Integer to English Words — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/integer-to-english-words/

---

## Solution: Recursive Chunking by Thousands — O(1) time, O(1) space

**Idea:** Break the number into groups of three digits (ones, thousands, millions, billions). Convert each group of up to three digits using a helper, then prepend the appropriate scale word.

**Algorithm:**
1. Handle edge case `num == 0`.
2. Define lookup arrays: ones (1–19) and tens (20, 30, ..., 90).
3. `helper(n)` converts a number 1–999 to words:
   - If `n >= 100`: prepend `ones[n/100] + " Hundred"`, recurse on remainder.
   - If `n >= 20`: prepend `tens[n/10 - 2]`, recurse on `n % 10`.
   - Otherwise use `ones[n]` directly.
4. Chunk `num` by 1000. For each non-zero chunk, call `helper` and append the scale suffix (Billion, Million, Thousand, or none).

**Complexity:**

| | |
|---|---|
| Time | O(1) — bounded by constant 32-bit input size |
| Space | O(1) — fixed lookup tables, bounded recursion depth |
