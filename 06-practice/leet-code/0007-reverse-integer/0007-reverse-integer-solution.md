# 7. Reverse Integer — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/reverse-integer/

---

## Solution

### Digit-by-Digit Reversal with Overflow Check — O(log x) time, O(1) space

**Idea:** Pop the last digit of `x` with `x % 10` and push it onto the result. Check for overflow *before* each push so we never need a 64-bit intermediate.

**Algorithm:**
1. Initialize `result = 0`.
2. While `x != 0`:
   - `digit = x % 10`
   - `x /= 10`
   - Before updating: check if `result * 10 + digit` would overflow:
     - Overflow if `result > INT_MAX / 10` or (`result == INT_MAX / 10` and `digit > 7`)
     - Underflow if `result < INT_MIN / 10` or (`result == INT_MIN / 10` and `digit < -8`)
   - If overflow, return `0`. Otherwise `result = result * 10 + digit`.
3. Return `result`.

**Why check before multiplying:** We cannot compute `result * 10` first because that itself might overflow. Instead we rearrange the inequality: `result * 10 + digit > INT_MAX` ↔ `result > (INT_MAX - digit) / 10`.

**Sign handling:** In most languages, `%` preserves sign for negative operands, so digits pop out negative automatically. No special sign handling needed.

**Complexity:**

| | |
|---|---|
| Time | O(log₁₀ x) — number of digits in x |
| Space | O(1) |
