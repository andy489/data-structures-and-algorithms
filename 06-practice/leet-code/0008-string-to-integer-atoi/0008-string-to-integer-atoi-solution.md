# 8. String to Integer (atoi) — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/string-to-integer-atoi/

---

## Solution

### State Machine / Linear Scan — O(n) time, O(1) space

**Idea:** Process the string in four sequential phases: strip whitespace → read sign → accumulate digits → clamp.

**Algorithm:**
1. Skip leading spaces.
2. Check for `'+'` or `'-'`; record sign (+1 or -1). Advance past the sign character.
3. Accumulate digits: for each digit character `c`:
   - `digit = c - '0'`
   - Before updating: check overflow using the same technique as problem 7 (compare `result` against `INT_MAX / 10` and remainder digit against 7).
   - `result = result * 10 + digit`
4. Return `sign * result`, clamped to `[-2^31, 2^31 - 1]`.

**Key subtlety:** Overflow detection must happen before the multiplication. The clamping direction depends on the sign: positive overflow → `INT_MAX`, negative overflow → `INT_MIN`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
