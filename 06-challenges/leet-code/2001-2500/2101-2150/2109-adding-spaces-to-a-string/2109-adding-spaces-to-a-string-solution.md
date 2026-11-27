# 2109. Adding Spaces to a String — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/adding-spaces-to-a-string/

---

## Solution: Two Pointers with StringBuilder — O(n + m) time, O(n + m) space

**Idea:** Use a pointer `j` over the `spaces` array and a pointer `i` over `s`. Append characters to a `StringBuilder`, inserting a space whenever `i == spaces[j]`.

**Algorithm:**
1. Initialize `StringBuilder sb`, pointer `j = 0`.
2. For each index `i` from `0` to `s.length - 1`:
   - If `j < spaces.length` and `i == spaces[j]`, append `' '` and increment `j`.
   - Append `s.charAt(i)`.
3. Return `sb.toString()`.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — n = length of s, m = number of spaces |
| Space | O(n + m) — output string length |
