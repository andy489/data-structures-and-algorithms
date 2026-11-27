# 313. Super Ugly Number — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/super-ugly-number/

---

## Solution: Min-Heap (k-way Merge) — O(n * k * log k) time, O(k) space

**Idea:** Use a min-heap seeded with 1. At each step, pop the minimum, and push `min * primes[i]` for each prime. Use a set to avoid duplicates.

**Algorithm:**
1. Initialize heap with `(1, 0)` (value, prime index) and a visited set.
2. Pop `n` times; each pop gives the next ugly number.
3. For each popped value, push `val * primes[i]` for all primes if not visited.

**Complexity:**

| | |
|---|---|
| Time | O(n * k * log(n*k)) — heap ops |
| Space | O(n * k) — heap size |

---

## Solution 2: DP with k Pointers — O(n * k) time, O(n + k) space

**Idea:** Maintain one pointer per prime. The next ugly number is `min(ugly[ptr[i]] * primes[i])` over all primes. Advance all pointers whose product equals the new minimum.

**Algorithm:**
1. `dp[0] = 1`, `ptrs[i] = 0` for each prime.
2. For each `j` from 1 to n-1: `dp[j] = min(dp[ptrs[i]] * primes[i])` for all `i`.
3. Advance any pointer where `dp[ptrs[i]] * primes[i] == dp[j]`.

**Complexity:**

| | |
|---|---|
| Time | O(n * k) — no heap, linear scan |
| Space | O(n + k) — dp array and pointers |
