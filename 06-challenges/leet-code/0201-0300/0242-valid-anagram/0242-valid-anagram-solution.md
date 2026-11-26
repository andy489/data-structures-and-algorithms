# 242. Valid Anagram — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-anagram/

---

## Solution: Frequency Count — O(n) time, O(1) space

**Idea:** Count character frequencies in `s` and subtract frequencies from `t`. If any count is non-zero, the strings are not anagrams.

**Algorithm:**
1. If `s.length != t.length` return `false`.
2. Maintain `int[26] count`.
3. For each index `i`: `count[s[i]-'a']++`, `count[t[i]-'a']--`.
4. Return `true` iff all counts are zero.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — fixed 26-element array |
