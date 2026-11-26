# 1137. N-th Tribonacci Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/n-th-tribonacci-number/

---

## Solution: Naive Recursion — O(3^n) time, O(n) space

**Idea:** Direct translation of the mathematical definition. Each call branches into three recursive calls, producing an exponential call tree with massive redundancy.

**Algorithm:**
1. Base cases: return `0` for `n == 0`, `1` for `n <= 2`.
2. Recursive case: return `trib(n-1) + trib(n-2) + trib(n-3)`.

**Complexity:**

| | |
|---|---|
| Time | O(3^n) — ternary call tree, each node recomputed |
| Space | O(n) — recursion depth |

---

## Solution 2: Recursive with Memoisation — O(n) time, O(n) space

**Idea:** Cache each subproblem result so each `trib(k)` is computed exactly once. Eliminates the exponential redundancy of naive recursion.

**Algorithm:**
1. Base cases: return `0` for `n == 0`, `1` for `n <= 2`.
2. Look up `memo[n]`; if present, return it.
3. Otherwise compute `trib(n-1) + trib(n-2) + trib(n-3)`, store in `memo[n]`, and return.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each subproblem computed once |
| Space | O(n) — recursion depth + memo table |

---

## Solution 3: Iterative DP with Rolling Array — O(n) time, O(1) space

**Idea:** Build bottom-up using a size-4 array with modular indexing. Each new value overwrites the slot no longer needed. The window size is 4 because the recurrence reads back 3 steps and we write 1 new value.

**Algorithm:**
1. Handle base cases: return `0` for `n == 0`, `1` for `n <= 2`.
2. Initialise `dp[0] = 0`, `dp[1] = 1`, `dp[2] = 1`.
3. For each `i` from `3` to `n`: `dp[i % 4] = dp[(i-1) % 4] + dp[(i-2) % 4] + dp[(i-3) % 4]`.
4. Return `dp[n % 4]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single loop |
| Space | O(1) — fixed-size array of 4 |

---

## Solution 4: Matrix Exponentiation — O(log n) time, O(1) space

**Idea:** The Tribonacci recurrence maps to a 3×3 matrix multiplication:

```
| T(n+1) |   | 1 1 1 |   | T(n)   |
| T(n)   | = | 1 0 0 | × | T(n-1) |
| T(n-1) |   | 0 1 0 |   | T(n-2) |
```

Raise `[[1,1,1],[1,0,0],[0,1,0]]` to the power `n-2` (starting from state `[T(2), T(1), T(0)] = [1, 1, 0]`), then read off `result[0][0] + result[0][1]`.

**Deriving the companion matrix:** For any k-term linear recurrence `T(n) = c₁·T(n-1) + c₂·T(n-2) + … + cₖ·T(n-k)`, build a k×k **companion matrix** `M`:
- **Row 0** (top row): the coefficients `[c₁, c₂, …, cₖ]`
- **Rows 1 … k-1**: a shifted identity — row `i` has a `1` in column `i-1`, zeros elsewhere

This encodes the recurrence as a single matrix-vector multiplication: `M · [T(n), T(n-1), …, T(n-k+1)]ᵀ = [T(n+1), T(n), …, T(n-k+2)]ᵀ`.

For Tribonacci (k=3, c₁=c₂=c₃=1):
```
M = | 1 1 1 |    row 0: [1, 1, 1]
    | 1 0 0 |    row 1: identity shift → [1, 0, 0]
    | 0 1 0 |    row 2: identity shift → [0, 1, 0]
```
Starting from `[T(2), T(1), T(0)]ᵀ = [1, 1, 0]ᵀ`, applying `M^(n-2)` gives `[T(n), T(n-1), T(n-2)]ᵀ`, so `T(n) = (M^(n-2))[0][0]·1 + (M^(n-2))[0][1]·1 + (M^(n-2))[0][2]·0 = result[0][0] + result[0][1]`.

**Algorithm:**
1. Base cases: return `0` for `n == 0`, `1` for `n <= 2`.
2. Compute `M ^ (n-2)` via recursive squaring.
3. Return `result[0][0] + result[0][1]`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — halving the exponent at each step |
| Space | O(1) — constant-size 3×3 matrices (O(log n) call stack) |
