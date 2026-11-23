# 389. Find the Difference — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-difference/

---

## Solution: XOR — O(n) time, O(1) space

**Idea:** XOR all characters in both strings. Each character in `s` appears exactly once in both, so they cancel. The extra character in `t` remains.

**Algorithm:**
1. XOR all chars in `s` and `t`.
2. The result is the extra character.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
