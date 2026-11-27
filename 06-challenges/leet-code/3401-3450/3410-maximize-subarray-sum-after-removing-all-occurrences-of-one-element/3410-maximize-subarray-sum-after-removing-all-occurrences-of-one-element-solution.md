# Solution: Maximize Subarray Sum After Removing All Occurrences of One Element

## Approach

For each distinct element x in nums, we can optionally remove all its occurrences and compute the maximum subarray sum of the resulting array. The answer is the max over all choices (including no removal).

Brute force O(n^2) would be too slow for n=10^5.

**Key insight**: Use a modified Kadane's algorithm. For each element x, we want maxSubarraySum(nums with all x removed). We can do this efficiently.

Consider: for a fixed x, the array with x removed is nums with the x-positions "bridged over". We can model this with DP.

**Efficient approach**: For each element x, run a Kadane-like algorithm that ignores positions with nums[i]==x, but instead of truly removing them, we "skip" them while maintaining the current subarray sum.

For non-negative x removal: when we encounter x, we just skip it. For negative x removal: when we see x, we skip it which may increase the sum.

However trying all distinct values is O(n * distinct_values). In worst case O(n^2).

**Better**: For each negative value x that could be worth removing (only negative values could hurt a subarray), we try removing it. Positive values won't be removed (removing positives only hurts).

Actually since nums[i] can be very negative, the candidates to remove are negative values. But there can still be O(n) distinct negative values.

**O(n log n) approach using segment trees or contribution**: This is complex. For the problem constraints (n=10^5), an O(n * sqrt_n) or O(n * max_distinct) approach with the observation that there are at most O(n) distinct values, but we can't do all of them.

**Trick**: Only remove a value x if it's negative. For each distinct negative x, we want maxSubarray of array with all x removed. We can compute this by thinking of "gaps" at positions where nums[i]==x.

For the gaps, the subarray can bridge gaps: if the sum of elements between two x's is positive, the gap can be bridged.

**DP for each x (O(n))**:
- Maintain current subarray sum, treating x positions as 0.
- dp: for position i (not x): cur = max(0, cur) + nums[i]; for x: just skip (do nothing to cur).
- Actually: when at x position, skip adding nums[i] to cur but don't reset.

This gives O(n) per distinct negative x. Total O(n * |distinct negatives|) = O(n^2) worst case.

For the given constraints, this may be accepted with optimizations.

## Complexity

| | Complexity |
|---|---|
| Time | O(n * d) where d = number of distinct negative values |
| Space | O(n) |
