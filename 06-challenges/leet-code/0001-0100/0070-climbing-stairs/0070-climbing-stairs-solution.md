# 70. Climbing Stairs — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/climbing-stairs/

---

## Solution: Fibonacci iteration — O(n) time, O(1) space

**Idea:**

To reach step `n` you must come from either step `n-1` (take 1 step) or step `n-2` (take 2 steps). So the number of ways satisfies the Fibonacci recurrence:

```
ways(n) = ways(n-1) + ways(n-2)
```

with base cases `ways(1) = 1`, `ways(2) = 2`. We only ever need the previous two values, so constant space suffices.

**Algorithm:**
1. If `n <= 2`, return `n` directly.
2. Initialize `prev2 = 1`, `prev1 = 2`.
3. For `i` from 3 to `n`: `curr = prev1 + prev2`; shift `prev2 = prev1`, `prev1 = curr`.
4. Return `prev1`.

**Trace:** `n = 5`

```
i=3: curr=3   prev2=2, prev1=3
i=4: curr=5   prev2=3, prev1=5
i=5: curr=8   prev2=5, prev1=8
→ 8
```

**Complexity:**

| | |
|---|---|
| Time | O(n) — one pass |
| Space | O(1) — two variables |

---

## Solution 2: Bottom-up DP — O(n) time, O(n) space

**Idea:**

Same recurrence, but store all values in a `dp` array. Trades space for explicitness — every intermediate result is accessible, which can be useful for debugging or variations of the problem.

**Algorithm:**
1. Allocate `dp[1..n]`; set `dp[1] = 1`, `dp[2] = 2`.
2. Fill `dp[i] = dp[i-1] + dp[i-2]` for `i` from 3 to `n`.
3. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — dp array |

---

## Solution 3: Matrix exponentiation — O(log n) time, O(1) space

**Idea:**

The Fibonacci recurrence can be expressed as a matrix power:

```
[F(n+1)]   [1 1]^n   [1]
[F(n)  ] = [1 0]   * [0]
```

Repeated squaring computes the n-th power in O(log n) matrix multiplications, each O(1) for a 2×2 matrix. Overkill for `n ≤ 45` (which fits in a simple loop), but demonstrates the general technique for arbitrary-precision or very large `n`.

**Algorithm:**
1. Start with identity matrix `result = I`.
2. Repeatedly square the base matrix and multiply into `result` for each set bit in `n` (binary exponentiation).
3. Return `result[0][0]`, which equals `F(n+1)` = `climbStairs(n)`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — O(log n) matrix multiplications, each O(1) for 2×2 |
| Space | O(1) — constant number of 2×2 matrices |
