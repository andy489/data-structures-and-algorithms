# 1790. Check if One String Swap Can Make Strings Equal — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

---

## Solution: Collect Differing Positions — O(n) time, O(1) space

**Idea:** Collect positions where `s1` and `s2` differ. There are three valid cases: 0 differences (strings are equal), or exactly 2 differences where swapping the two characters in one string resolves both differences (i.e., `s1[i] == s2[j]` and `s1[j] == s2[i]`).

**Algorithm:**
1. Find all indices where `s1[i] != s2[i]`.
2. If 0 differences: return `true`.
3. If 2 differences at indices `i`, `j`: return `s1[i] == s2[j] and s1[j] == s2[i]`.
4. Otherwise: return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single scan |
| Space | O(1) — at most 2 indices stored |
