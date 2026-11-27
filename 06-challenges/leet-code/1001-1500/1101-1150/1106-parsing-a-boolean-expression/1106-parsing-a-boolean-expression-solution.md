# 1106. Parsing A Boolean Expression — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/parsing-a-boolean-expression/

---

## Solution: Stack-Based Parsing — O(n) time, O(n) space

**Idea:** Use a stack to process characters left to right. When we encounter a `)`, pop everything back to the matching `(` to collect the sub-results, then apply the operator stored just before the `(`.

**Algorithm:**
1. Iterate through each character `c` in `expression`:
   - If `c` is not `)`, push it onto the stack.
   - If `c` is `)`, pop characters until we find `(`, collecting `'t'` and `'f'` values into a list. Then pop the operator (`!`, `&`, `|`) from the stack. Evaluate the collected values with the operator and push the result (`'t'` or `'f'`) back.
2. The single remaining element on the stack is the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each character is pushed and popped at most once |
| Space | O(n) — the stack can hold up to n characters |

---

## Solution 2: Recursive Parsing — O(n) time, O(n) space

**Idea:** Parse the expression recursively using an index pointer. At each call, read the operator and recursively parse sub-expressions, then apply the operator.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(d) — recursion depth d, at most O(n) |
