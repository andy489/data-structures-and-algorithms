# Solution for 3920. Maximize Fixed Points After Deletions

## Approach

**Longest non-decreasing subsequence with offset:**

After deleting some elements, the remaining elements at positions (0-indexed in original array) form a subsequence. If we keep elements at original indices `i_1 < i_2 < ... < i_m`, they get new indices `0, 1, ..., m-1`.

Element at original index `i_j` becomes a fixed point if `nums[i_j] == j - 1` (new 0-indexed position).

**Key insight:** We want to maximize the number of elements `nums[i]` we keep such that for each kept element, its new index equals `nums[i]`. If we keep element `nums[i]` as the `j`-th element (0-indexed), we need `nums[i] == j`.

This is equivalent to finding the longest subsequence of `nums` where `nums[i_0] = 0, nums[i_1] = 1, nums[i_2] = 2, ...` as a non-decreasing match.

**DP approach:** Let `dp[v]` = maximum number of fixed points achievable if the last fixed point we kept had value `v`. Scan `nums` from left to right. For each element `nums[i]`, if we decide to make it a fixed point with new index `v = nums[i]`, then `dp[v] = dp[v-1] + 1` (the previous fixed point must have value v-1 and appear before i).

This requires that we can find at index i an element with value v, preceded by fixed points of values 0, 1, ..., v-1.

**Simpler DP:** `dp[i]` = max fixed points ending at index i (where nums[i] is the last fixed point). `dp[i] = dp[j] + 1` for all j < i where `nums[j] = nums[i] - 1`. Use a dictionary/array: `best[v]` = max fixed points achievable with last value v.

## Complexity

- Time: O(n)
- Space: O(max_val)
