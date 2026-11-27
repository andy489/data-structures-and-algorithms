# Solution: The Number of Good Subsets

## Approach: Bitmask DP on Primes

Since `nums[i] <= 30`, the primes involved are `{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}` — 10 primes total, so we can represent used primes as a 10-bit bitmask.

1. Count frequency of each number 1..30.
2. Skip numbers with squared prime factors (4, 8, 9, 12, ...) — they can't be in a good subset.
3. For each valid number `v > 1`, compute its prime bitmask. Use DP: `dp[mask]` = number of subsets with product whose prime factorization corresponds to `mask`.
4. For each `v`, transition: for each existing `dp[prevMask]` where `prevMask & primeMask[v] == 0`, add `count[v] * dp[prevMask]` to `dp[prevMask | primeMask[v]]`.
5. The 1s contribute a multiplier of `2^count[1]` to all non-empty subsets.

**Time:** O(30 * 2^10)  
**Space:** O(2^10)
