# 509. Fibonacci Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/fibonacci-number/

---

## Solution: Naive Recursion — O(2^n) time, O(n) space

**Idea:** Direct translation of the mathematical definition. Each call branches into two recursive calls, producing an exponential call tree with many redundant subproblems.

**Algorithm:**
1. Base case: return `n` for `n <= 1`.
2. Recursive case: return `fib(n - 1) + fib(n - 2)`.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) — binary call tree, each node recomputed |
| Space | O(n) — recursion depth |

---

## Solution 2: Recursive with Memoisation — O(n) time, O(n) space

**Idea:** Cache each subproblem result so each `fib(k)` is computed exactly once. Eliminates the exponential redundancy of naive recursion while keeping the recursive structure.

**Algorithm:**
1. Base case: return `n` for `n <= 1`.
2. Look up `memo[n]`; if present, return it.
3. Otherwise compute `fib(n - 1) + fib(n - 2)`, store in `memo[n]`, and return.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each subproblem computed once |
| Space | O(n) — recursion depth + memo table |

---

## Solution 3: Iterative DP with Rolling Array — O(n) time, O(1) space

**Idea:** Build bottom-up using a size-3 array with modular indexing. Each new value overwrites the slot no longer needed. Demonstrates the rolling-array pattern that generalises to recurrences with wider windows (e.g. tribonacci).

**Algorithm:**
1. Initialise `dp[0] = 0`, `dp[1] = 1`.
2. For each `i` from `2` to `n`: `dp[i % 3] = dp[(i-1) % 3] + dp[(i-2) % 3]`.
3. Return `dp[n % 3]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single loop |
| Space | O(1) — fixed-size array of 3 |

---

## Solution 4: Matrix Exponentiation — O(log n) time, O(log n) space

**Idea:** The Fibonacci recurrence maps to matrix multiplication:

```
| F(n+1)  F(n)   |   | 1  1 | ^ n
| F(n)    F(n-1) | = | 1  0 |
```

Raise the base matrix to the n-th power using repeated squaring to compute `F(n)` in O(log n) steps.

**Deriving the companion matrix:** For any k-term linear recurrence `T(n) = c₁·T(n-1) + c₂·T(n-2) + … + cₖ·T(n-k)`, build a k×k **companion matrix** `M`:
- **Row 0** (top row): the coefficients `[c₁, c₂, …, cₖ]`
- **Rows 1 … k-1**: a shifted identity — row `i` has a `1` in column `i-1`, zeros elsewhere

This encodes the recurrence as a single matrix-vector multiplication: `M · [T(n), T(n-1), …, T(n-k+1)]ᵀ = [T(n+1), T(n), …, T(n-k+2)]ᵀ`.

For Fibonacci (k=2, c₁=c₂=1):
```
M = | 1  1 |    row 0: [1, 1]
    | 1  0 |    row 1: identity shift → [1, 0]
```
`M^n · [F(1), F(0)]ᵀ = [F(n+1), F(n)]ᵀ`, so `F(n) = (M^n)[0][1]`.

**Algorithm:**
1. Base case: return `n` for `n <= 1`.
2. Compute `[[1,1],[1,0]] ^ n` via recursive squaring (`matpow`).
3. Return `result[0][1]` which equals `F(n)`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — halving the exponent at each step |
| Space | O(log n) — recursion depth of matpow |
