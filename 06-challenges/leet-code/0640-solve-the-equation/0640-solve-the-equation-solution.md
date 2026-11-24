# 640. Solve the Equation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/solve-the-equation/

---

## Solution: Parse Both Sides — O(n) time, O(1) space

**Idea:** Parse each side of the equation into coefficient of x and constant. Left side: `ax + b`; right side: `cx + d`. Equation: `(a-c)x = d-b`.

**Algorithm:**
1. Split on `=`.
2. Parse each side: accumulate x-coefficients and constants, tracking sign.
3. `xCoef = leftX - rightX`, `constVal = rightConst - leftConst`.
4. If xCoef == 0: "Infinite solutions" if constVal == 0, else "No solution".
5. Else: `x = constVal / xCoef`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
