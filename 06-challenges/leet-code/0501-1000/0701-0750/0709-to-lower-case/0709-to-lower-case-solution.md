# 709. To Lower Case — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/to-lower-case/

---

## Solution: Character Mapping — O(n) time, O(n) space

**Idea:** For each character, if it is uppercase (ASCII 65–90), convert to lowercase by adding 32 (or OR with 32). Otherwise keep it as-is.

**Algorithm:**
1. Build result by iterating characters.
2. For each char c: if `'A' <= c <= 'Z'`, add `c + 32`; else add `c`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — output string |
