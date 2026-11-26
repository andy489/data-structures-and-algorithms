# 844. Backspace String Compare — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/backspace-string-compare/

---

## Solution: Two Pointers — O(n + m) time, O(1) space

**Idea:** Use two pointers traversing from the end of each string. Count pending backspaces; skip characters accordingly.

**Algorithm:**
1. Start both pointers at the last character of `s` and `t`.
2. Maintain `skipS` and `skipT` counters.
3. If current char is `#`, increment skip counter; else if skip > 0, decrement and skip; else compare.
4. If characters differ, return false.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — single pass |
| Space | O(1) — no extra allocation |
