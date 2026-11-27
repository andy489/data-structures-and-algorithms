# Solution: Sorted GCD Pair Queries

## Approach: Count GCD Values + Binary Search

We can't enumerate all pairs (up to 10^10). Instead, count how many pairs have GCD exactly equal to each value using inclusion-exclusion via Euler's totient / Mobius function approach.

**Steps:**
1. Build frequency array `cnt[v]` = count of elements in `nums` divisible by `v`.
2. For each value `g` from max down to 1, `cnt[g]` = number of elements divisible by `g`. Number of pairs with GCD **exactly** `g` = C(cnt[g], 2) - sum of pairs with GCD that is a multiple of `g` (inclusion-exclusion).
   - `pairs[g] = C(cnt[g], 2) - sum(pairs[kg] for k >= 2)`.
3. Build prefix sum of `pairs[1], pairs[2], ..., pairs[maxVal]` to get cumulative count.
4. For each query, binary search on the prefix sum to find the answer GCD.

## Complexity

- **Time:** O(M log M) where M = max(nums[i]), for sieve-like counting. O(Q log M) for queries.
- **Space:** O(M).
