# 736. Parse Lisp Expression — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/parse-lisp-expression/

---

## Solution: Recursive Descent with Scope Stack — O(n²) time, O(n) space

**Idea:** Parse recursively. Use a scope (stack of variable maps) for let bindings. For each call, copy the current scope, add new bindings, evaluate the return expression.

**Algorithm:**
1. Use an index pointer into the string.
2. `parse(scope)`: if current char is `(`, read the operator (`let`/`add`/`mult`) and dispatch. Otherwise parse a number or variable name.
3. For `let`: repeatedly parse `varName`, evaluate expression, bind, until last token which is returned.
4. For `add`/`mult`: evaluate two sub-expressions and combine.
5. Variable lookup walks the scope stack.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — each token processed, scope copied per let |
| Space | O(n) — recursion depth + scopes |
