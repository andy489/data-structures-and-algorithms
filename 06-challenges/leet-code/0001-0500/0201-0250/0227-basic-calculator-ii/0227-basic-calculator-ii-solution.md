# 227. Basic Calculator II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/basic-calculator-ii/

---

## Solution: Stack with Eager Multiplication/Division — O(n) time, O(n) space

**Idea:** Scan the expression tracking the last operator. For `+`/`-` push the signed value onto the stack. For `*`/`/` pop the top, compute with the current number, and push the result. Sum the stack at the end.

**Algorithm:**
1. Maintain `num = 0`, `op = '+'`.
2. For each character: accumulate digits; on an operator or end of string, apply `op` to `num` and the stack.
3. For `+`: push `num`; for `-`: push `-num`; for `*`: push `stack.pop() * num`; for `/`: push `stack.pop() / num` (truncate toward zero).
4. Return sum of stack.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — stack |
