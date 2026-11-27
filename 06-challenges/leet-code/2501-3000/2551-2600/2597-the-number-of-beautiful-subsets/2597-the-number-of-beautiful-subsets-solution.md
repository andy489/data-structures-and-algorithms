# Solution: 2597. The Number of Beautiful Subsets

## Approach

Use **backtracking** with a frequency map to count non-empty beautiful subsets.

Sort `nums`. For each element, before including it, check if `num - k` is already in the current subset (using a count map). If not, add `num` to the subset (increment its count), recurse to include/exclude remaining elements, then backtrack.

Each recursive call either skips the current element or includes it, counting all valid non-empty subsets.

## Complexity

- **Time:** O(2^n) in worst case (n <= 18 so this is feasible)
- **Space:** O(n) for recursion stack and frequency map
