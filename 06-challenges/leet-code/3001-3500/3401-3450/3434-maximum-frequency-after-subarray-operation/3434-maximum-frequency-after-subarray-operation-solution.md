# 3434. Maximum Frequency After Subarray Operation — Solution

## Approach

We want to pick a subarray and add some value `x` to convert some elements equal to some value `v` (where `v + x = k`) into `k`. Outside the subarray, elements that are already `k` stay as `k`.

For each possible source value `v` (1..50, v != k), we want to find the maximum number of elements equal to `v` in a contiguous subarray (Kadane-style). The total answer for this choice of `v` is:
- `(count of k outside any subarray) + (best subarray gain from converting v to k)`
- Since we can pick the entire array as subarray, elements equal to `k` that we convert back are lost. We need to maximize: `(already_k_count outside subarray) + (count of v in subarray)`

We simplify: for each `v != k`, apply Kadane's algorithm on a transformed array where `nums[i] == v` gives +1, `nums[i] == k` gives -1, and others give 0. The best subarray sum gives how many extra `k`s we gain. Add the total count of k already in the array to get the frequency.

**Time Complexity:** O(50 * n)
**Space Complexity:** O(1)
