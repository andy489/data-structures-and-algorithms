# 405. Convert a Number to Hexadecimal — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/convert-a-number-to-hexadecimal/

---

## Solution: Bit Masking — O(1) time, O(1) space

**Idea:** Repeatedly extract the lowest 4 bits using `num & 0xf`, map them to a hex character, then right-shift by 4 (unsigned). Stop when num becomes 0 or we've done 8 iterations (32 bits / 4).

**Algorithm:**
1. Handle num=0 immediately.
2. Cast to unsigned by using `num & 0xffffffffL` (or in Java, work with int since `>>>` is unsigned).
3. Loop: take `num & 0xf`, prepend hex digit, shift right by 4.
4. Reverse and return.

**Complexity:**

| | |
|---|---|
| Time | O(1) — at most 8 iterations for 32 bits |
| Space | O(1) — fixed 8-char output at most |
