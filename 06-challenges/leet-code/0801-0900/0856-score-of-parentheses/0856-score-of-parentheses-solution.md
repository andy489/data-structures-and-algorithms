# 856. Score of Parentheses — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/score-of-parentheses/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Use a stack. Push 0 for each `(`. On `)`, pop the top value v. If v == 0, it was `()` → contribute max(2*v, 1) = 1. Otherwise contribute 2*v. Add result to new top.

**Algorithm:**
1. Start with stack = [0].
2. For each `(`, push 0.
3. For each `)`, pop v, top += max(2*v, 1).
4. Return stack[0].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — stack depth |
