# 678. Valid Parenthesis String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/valid-parenthesis-string/

---

## Solution: Greedy (Min/Max Open Count) — O(n) time, O(1) space

**Idea:** Track the range of possible open parenthesis counts `[lo, hi]`. `'('` increments both; `')'` decrements both; `'*'` can go either way so hi++ and lo--. If hi < 0 at any point, it's invalid. At end, valid if lo == 0.

**Algorithm:**
1. `lo = hi = 0`.
2. For each char: `'(' → lo++, hi++`; `')' → lo--, hi--`; `'*' → lo--, hi++`.
3. `lo = max(lo, 0)` (can't have negative open count).
4. If `hi < 0`, return false. At end, return `lo == 0`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
