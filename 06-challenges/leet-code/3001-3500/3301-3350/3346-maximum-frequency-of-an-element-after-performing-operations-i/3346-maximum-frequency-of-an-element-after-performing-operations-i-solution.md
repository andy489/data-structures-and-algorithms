# 3346. Maximum Frequency of an Element After Performing Operations I — Solution

## Approach: Sorting + Sliding Window / Sweep Line

For any target value `v`, the elements that can reach `v` are those in `[v-k, v+k]`. We want to maximize the count of elements equal to `v` after operations.

**Key insight:** The optimal target `v` is always an existing value in `nums`, because using an existing value means one element already equals `v` for free.

**Algorithm using sorting and sliding window:**
1. Sort `nums`.
2. For each element `nums[i]` as the target value `v`:
   - Use a sliding window to count elements in `[v-k, v+k]` = elements that can be changed to `v`.
   - The frequency = min(window_size, numOperations) + (1 if nums[i] is already counted, adjust for exact matches).
   - More precisely: existing exact matches at `v` don't cost operations; other elements in `[v-k, v+k]` each cost one operation.

**Refined approach using prefix sums:**
1. Sort `nums`.
2. For each unique target `v = nums[i]`:
   - Count existing elements equal to `v` (no ops needed).
   - Count elements in `[v-k, v+k]` that are NOT equal to `v` (each costs 1 op).
   - Answer for this target = exact_count + min(non_exact_in_range, numOperations - 0).
   - But we can only use `numOperations` total, so: answer = exact_count + min(non_exact_in_range, numOperations).

## Complexity

- **Time:** O(n log n) — sorting and binary search per element.
- **Space:** O(1) extra (excluding sort).
