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

## Solution 3: Iterative DP — O(n) time, O(1) space

**Idea:** Compute Fibonacci iteratively, keeping only the last two values. Eliminates both the call stack and the memo table.

**Algorithm:**
1. Handle base cases: return `n` for `n <= 1`.
2. Maintain `prev = 0`, `curr = 1`.
3. For each step from `2` to `n`: update `prev, curr = curr, prev + curr`.
4. Return `curr`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single loop |
| Space | O(1) — two variables |

---

## Solution 4: Matrix Exponentiation — O(log n) time, O(log n) space

**Idea:** The Fibonacci recurrence maps to matrix multiplication:

```
| F(n+1)  F(n)   |   | 1  1 | ^ n
| F(n)    F(n-1) | = | 1  0 |
```

Raise the base matrix to the n-th power using repeated squaring to compute `F(n)` in O(log n) steps.

**Algorithm:**
1. Base case: return `n` for `n <= 1`.
2. Compute `[[1,1],[1,0]] ^ n` via recursive squaring (`matpow`).
3. Return `result[0][1]` which equals `F(n)`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — halving the exponent at each step |
| Space | O(log n) — recursion depth of matpow |
