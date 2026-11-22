# 224. Basic Calculator — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/basic-calculator/

---

## Solution: Stack-based Evaluation — O(n) time, O(n) space

**Idea:** Track a running `result`, current `sign` (+1 or -1), and a stack to save (result, sign) pairs when entering parentheses. On `(`, push current result and sign; reset them. On `)`, pop and combine.

**Algorithm:**
1. Scan character by character.
2. Digit → accumulate `num`.
3. `+`/`-` → `result += sign * num`; set `sign`; reset `num`.
4. `(` → push `(result, sign)` onto stack; reset `result = 0`, `sign = 1`.
5. `)` → `result += sign * num`; then `result = result * stack.pop() + stack.pop()` (sign then saved_result).
6. After loop → add any remaining `num`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — stack depth equals nesting depth |
