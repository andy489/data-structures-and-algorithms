# 1614. Maximum Nesting Depth of the Parentheses — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

---

## Solution: One Pass Counter — O(n) time, O(1) space

**Idea:** Track the current open-paren depth and record the maximum depth seen.

**Algorithm:**
1. Initialize `depth = 0` and `maxD = 0`.
2. For each character in `s`:
   - If `'('`: increment `depth`, update `maxD = max(maxD, depth)`.
   - If `')'`: decrement `depth`.
3. Return `maxD`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the string |
| Space | O(1) — two integer counters |
