# 3350. Adjacent Increasing Subarrays Detection II — Solution

## Approach: Precompute Run Lengths + Binary Search or Linear Scan

Precompute `inc[i]` = length of strictly increasing run ending at index `i`.

For each boundary position `m` (between position m-1 and m, where the first subarray ends at m-1 and the second starts at m), the maximum `k` we can achieve at this boundary is `min(inc[m-1], inc[m + k - 1])`. But we need to find the maximum `k` such that `inc[m-1] >= k` and `inc[m-1 + k] >= k` (the second subarray starts at `m` and must have run length ≥ k at position `m + k - 1`).

**Simpler formulation:**
For each index `m` from 1 to n-1 (the split point), we know:
- The first subarray can have length at most `inc[m-1]` (run ending at m-1).
- For the second subarray starting at `m`, it must also have length `k`, ending at `m + k - 1`.
- We need `inc[m + k - 1] >= k`.

The maximum `k` at split `m` = `min(inc[m-1], max_k_starting_from_m)`.

The maximum `k` such that `inc[m + k - 1] >= k` can be found with binary search, or more simply: for a fixed `m`, the second subarray can have length at most `inc[m]` if we start at `m` (not exactly, but roughly). Actually `inc[m]` gives the run length ending at `m`, so a subarray starting at `m` and ending at `m + k - 1` requires checking `inc[m + k - 1] >= k`.

**Efficient approach:** For each split point `m`:
- `k1 = inc[m - 1]` (max first subarray length).
- For the second subarray: `k2 = inc[m + k2 - 1] >= k2`. This is satisfied for `k2 <= inc[m + k2 - 1]`. The max such `k2` can be found as the length of the increasing run starting at `m`, which equals `inc[m + L - 1]` where L is the run length starting at m. We can precompute `startInc[i]` = run length starting at `i`.
- Then answer at split `m` = `min(inc[m-1], startInc[m])`.
- Precompute `startInc[i]` in reverse: `startInc[n-1] = 1`, `startInc[i] = nums[i+1] > nums[i] ? startInc[i+1] + 1 : 1`.

## Complexity

- **Time:** O(n) — two linear passes for precomputation.
- **Space:** O(n) — for the `inc` and `startInc` arrays.
