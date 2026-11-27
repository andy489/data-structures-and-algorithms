# Solution: 2572. Count the Number of Square-Free Subsets

## Approach: Bitmask DP on Prime Factors

Since `nums[i] <= 30`, the primes up to 30 are: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 — exactly 10 primes.

A product is square-free iff each prime appears at most once in the factorization. We represent the set of used primes as a bitmask of 10 bits (2^10 = 1024 states).

**Key Observations:**
1. Any number with a perfect square factor (like 4, 8, 9, 12, 16, 18, 25, 27) **cannot** be in a square-free subset at all — skip them.
2. The number 1 contributes no primes, so each 1 doubles the count of existing subsets (each subset can include or exclude any 1).

**DP Definition:**
- `dp[mask]` = number of ways to form a subset whose product's prime factorization uses exactly the primes indicated by `mask`.

**Transitions:**
For each number `x` with prime bitmask `prime_mask(x)`:
- If `x` has any repeated prime factor, skip it.
- Otherwise, for all existing `dp[mask]` where `mask & prime_mask(x) == 0`, add `dp[mask]` to `dp[mask | prime_mask(x)]`.

**Count of 1s:** Let `ones` = count of 1s in nums. Each existing non-empty subset can pair with any subset of the 1s (2^ones choices). Add `2^ones - 1` for the subsets consisting only of 1s.

Actually: process numbers >= 2 first with DP. Then multiply the total by `2^(count of 1s)`.

**Result:** Sum of all `dp[mask]` for mask != 0, multiplied by `2^(count_1s)`, plus `(2^count_1s - 1)` for 1-only subsets. 

Simplified: At the end, multiply entire dp sum by `2^count_1s`.

## Complexity

- **Time:** O(n * 2^10) = O(1024 * n)
- **Space:** O(2^10) = O(1024)
