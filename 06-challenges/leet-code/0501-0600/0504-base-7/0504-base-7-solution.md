# 504. Base 7 — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/base-7/

---

## Solution: Repeated Division — O(log₇ n) time, O(log₇ n) space

**Idea:** Repeatedly divide by 7, collecting remainders. Handle sign separately. Special case num=0.

**Algorithm:**
1. If num == 0, return "0".
2. Record sign; work with absolute value.
3. While num > 0: prepend `num % 7`, divide num by 7.
4. Prepend "-" if negative.

**Complexity:**

| | |
|---|---|
| Time | O(log₇ n) |
| Space | O(log₇ n) — result string |
