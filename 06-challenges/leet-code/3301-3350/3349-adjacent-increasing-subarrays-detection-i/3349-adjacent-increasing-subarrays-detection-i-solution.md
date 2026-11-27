# 3349. Adjacent Increasing Subarrays Detection I — Solution

## Approach: Precompute Strictly Increasing Run Lengths

For each position `i`, precompute `inc[i]` = the length of the strictly increasing run ending at `i` (i.e., the maximum `l` such that `nums[i-l+1..i]` is strictly increasing).

Then for each potential start `a` of the first subarray (from 0 to n - 2k), check if `inc[a + k - 1] >= k` and `inc[a + 2k - 1] >= k`. If both hold, return `true`.

This works because `inc[a + k - 1] >= k` means there is a run of at least `k` strictly increasing values ending at `a + k - 1`, which means `nums[a..a+k-1]` is strictly increasing.

## Complexity

- **Time:** O(n) — single pass for `inc`, then O(n) check.
- **Space:** O(n) — for the `inc` array.
