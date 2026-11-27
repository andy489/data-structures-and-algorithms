# 921. Minimum Add to Make Parentheses Valid — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

---

## Solution: Balance Counter — O(n) time, O(1) space

**Idea:** Track open (unmatched `(`) and close (unmatched `)`). Each unmatched `)` needs a `(` added; each unmatched `(` needs a `)` added.

**Algorithm:**
1. For each char: if `(`, open++; else if open > 0, open-- (matched); else close++.
2. Return open + close.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
