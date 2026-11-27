# 3347. Maximum Frequency of an Element After Performing Operations II — Solution

## Approach: Sorting + Sweep Line with Difference Array

The key difference from part I is that `nums[i]` can be up to `10^9`, so we need coordinate compression and a sweep line approach.

**Algorithm:**
1. Sort `nums`.
2. For each element `v = nums[i]` as a potential target:
   - Elements in `[v-k, v+k]` can be changed to `v` (cost 1 operation each).
   - Elements already equal to `v` cost 0 operations.
   - Answer for target `v` = exact_count + min(elements_in_range_non_exact, numOperations).
3. Use a sweep line / difference array over unique values:
   - For each element `x`, it contributes +1 to range `[x-k, x+k]` as a "reachable" count.
   - Use events: at coordinate `x-k` add +1, at `x+k+1` subtract 1.
   - Process events in sorted order along with actual values to query how many can reach each target.

**Simpler equivalent (since we only check existing values as targets):**
- Sort `nums`, then for each unique `v`, binary search for the window `[v-k, v+k]`.
- This is the same O(n log n) approach as part I since the binary search handles large values.

The constraint increase (values up to 10^9 vs 10^5) doesn't change the binary search approach at all — we just search the sorted array directly.

## Complexity

- **Time:** O(n log n) — sorting and binary search per distinct value.
- **Space:** O(1) extra (excluding sort).
