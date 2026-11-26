# 1017. Convert to Base -2 — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/convert-to-base-2/

---

## Solution: Repeated Division — O(log n) time, O(log n) space

**Idea:** Repeatedly divide n by -2. The remainder is always 0 or 1 (adjust if negative). Collect bits in reverse.

**Algorithm:**
1. While n != 0: bit = n % (-2) using adjusted modulo (always 0 or 1); prepend bit; n = (n - bit) / (-2).
2. If result empty, return "0".

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(log n) |
