# 770. Basic Calculator IV — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/basic-calculator-iv/

---

## Solution: Polynomial Arithmetic with Recursive Parser — O(n · 2^n) time, O(2^n) space

**Idea:** Represent an expression as a polynomial: a map from sorted variable tuples to integer coefficients. Implement `add`, `sub`, `mul` on polynomials. Parse the expression recursively or with a stack handling operator precedence (`*` before `+/-`) and parentheses.

**Algorithm:**
1. Parse tokens left to right; handle `(` `)` with recursion/stack.
2. Each atom is either a constant (polynomial with just the constant) or a variable (polynomial `{(var,): 1}`).
3. After substituting `evalvars`, eliminate those variables.
4. Output non-zero terms sorted: highest degree first, then lexicographically.

**Complexity:**

| | |
|---|---|
| Time | O(n · 2^n) — polynomial multiplication can double terms |
| Space | O(2^n) — polynomial representation |
