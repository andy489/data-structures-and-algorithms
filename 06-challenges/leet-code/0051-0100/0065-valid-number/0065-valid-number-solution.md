# 65. Valid Number — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/valid-number/

---

## Solution: Linear scan with flags — O(n) time, O(1) space

**Idea:**

Scan the string once, tracking three boolean flags:
- `seenDigit` — at least one digit has appeared in the current segment
- `seenDot` — a dot has appeared (only allowed once, only before `e`/`E`)
- `seenE` — an `e` or `E` has appeared (only allowed once)

At each character:
- `+`/`-`: only valid at position 0 or immediately after `e`/`E`
- `.`: only valid if no dot and no `e`/`E` seen yet
- `e`/`E`: only valid if a digit has been seen and no `e`/`E` yet; reset `seenDigit` (digits must follow the exponent marker)
- digit: set `seenDigit`
- anything else: return false

At the end, `seenDigit` must be true (handles the case where the string ends with `e`, `e+`, `.`, etc.).

**Algorithm:**
1. Initialise `seenDigit = seenDot = seenE = false`.
2. For each character at index `i`:
   - `+`/`-`: valid only if `i == 0` or `s[i-1]` is `e`/`E`; else return false.
   - `.`: valid only if `!seenDot && !seenE`; set `seenDot = true`.
   - `e`/`E`: valid only if `!seenE && seenDigit`; set `seenE = true`, reset `seenDigit = false`.
   - `0`–`9`: set `seenDigit = true`.
   - else: return false.
3. Return `seenDigit`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — three boolean flags |
