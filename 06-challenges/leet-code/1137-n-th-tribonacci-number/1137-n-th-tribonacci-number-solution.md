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
