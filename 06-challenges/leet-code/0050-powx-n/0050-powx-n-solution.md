# 50. Pow(x, n) — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/powx-n/

---

## Solution: Fast exponentiation (exponentiation by squaring) — O(log n) time, O(log n) space

**Idea:** Halve the exponent at each step: if `n` is even, `x^n = (x^2)^(n/2)`; if odd, `x^n = x * x^(n-1)`. This reduces the problem to O(log n) multiplications. Handle negative `n` by computing `1 / pow(x, -n)`. Use `long` for `n` to avoid overflow when negating `Integer.MIN_VALUE`.

**Algorithm:**
1. If `n < 0`: return `1.0 / pow(x, -n)` (cast `n` to `long` first to handle `MIN_VALUE`).
2. If `n == 0`: return `1.0`.
3. If `n` is even: return `pow(x * x, n / 2)`.
4. If `n` is odd: return `x * pow(x * x, n / 2)`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — exponent halves each recursive call |
| Space | O(log n) — recursion depth |

---

## Solution 2: Iterative fast exponentiation — O(log n) time, O(1) space

**Idea:** Process the bits of `|n|` from LSB to MSB. Maintain a running `result` and square `x` at each step. If the current bit is set, multiply `result` by `x`.

**Algorithm:**
1. Let `p = |n|` (as `long`), `result = 1.0`.
2. While `p > 0`: if `p & 1` is set, `result *= x`. Square `x`. Right-shift `p`.
3. Return `n < 0 ? 1.0 / result : result`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — one iteration per bit of n |
| Space | O(1) — no recursion |
