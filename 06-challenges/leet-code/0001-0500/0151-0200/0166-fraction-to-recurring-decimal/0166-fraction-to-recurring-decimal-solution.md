# 166. Fraction to Recurring Decimal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/fraction-to-recurring-decimal/

---

## Solution: Long Division with HashMap — O(d) time, O(d) space

**Idea:** Perform long division. Record the index in the decimal string where each remainder first appeared. When we see a repeated remainder, we've found the repeating cycle — wrap it in parentheses and stop. If remainder reaches 0, the decimal terminates.

**Key edge cases:**
- Handle sign: negative if exactly one of numerator/denominator is negative.
- Use `long` to avoid overflow (`-2^31 / -1 = 2^31` overflows int).
- Work with absolute values.

**Algorithm:**
1. Handle sign; convert both to `long` and take absolute values.
2. Append integer part `num / den`. If `num % den == 0`, done.
3. Append `'.'`. Use a HashMap `remainderIndex` mapping remainder → index in fractional string builder.
4. Loop: `rem = rem * 10`. If `rem` seen before, insert `(` at saved index and append `)`. Else append `rem / den`, record `rem`, set `rem = rem % den`.

**Complexity:**

| | |
|---|---|
| Time | O(d) — at most `d` remainders before repeat |
| Space | O(d) — map + string |
