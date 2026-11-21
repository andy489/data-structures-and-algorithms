# 150. Evaluate Reverse Polish Notation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/evaluate-reverse-polish-notation/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Scan tokens left-to-right. Push numbers onto a stack. When an operator is encountered, pop two operands, apply the operator, and push the result. The final value on the stack is the answer.

**Algorithm:**
1. Iterate over `tokens`:
   - If the token is a number, push it.
   - If it's an operator, pop `b` then `a` (note order: `a op b`), compute, push result.
2. Return `stack.top()`.

**Truncation toward zero:** Java's `/` truncates toward zero natively. Python's `//` floors (different for negatives) — use `int(a / b)` instead.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — stack holds at most n/2 numbers |
