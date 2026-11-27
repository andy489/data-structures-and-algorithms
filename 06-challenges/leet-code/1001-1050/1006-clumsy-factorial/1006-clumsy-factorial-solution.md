# 1006. Clumsy Factorial — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/clumsy-factorial/

---

## Solution: Stack Simulation — O(n) time, O(n) space

**Idea:** Use a stack to handle operator precedence. *, / applied immediately to stack top; + pushes value; - pushes negated value. Sum the stack at end.

**Algorithm:**
1. Start with n on stack, op index 0.
2. For each subsequent value i from n-1 to 1: apply current op (op%4).
3. Sum the stack.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
