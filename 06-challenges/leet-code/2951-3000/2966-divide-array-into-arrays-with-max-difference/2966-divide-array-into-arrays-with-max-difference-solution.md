# Solution: Divide Array Into Arrays With Max Difference

## Approach: Sort then Greedy

Sort the array. After sorting, divide into consecutive groups of 3. For each group, if the difference between the first and last element exceeds k, it's impossible to satisfy conditions. Return empty array.

After sorting, within any valid grouping, elements in a group must be close together — and sorting guarantees that the optimal grouping is consecutive triplets.

## Complexity

| | Time | Space |
|---|---|---|
| **Sort + Greedy** | **O(n log n)** | **O(n)** |

## Key Insight

After sorting, any valid partition must use consecutive elements in sorted order. If group [i, i+1, i+2] after sorting satisfies nums[i+2] - nums[i] <= k, then it's valid. Otherwise, no valid grouping exists.
