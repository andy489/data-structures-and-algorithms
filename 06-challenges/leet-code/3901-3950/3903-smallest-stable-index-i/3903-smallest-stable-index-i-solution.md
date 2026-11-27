# Solution for 3903. Smallest Stable Index I

## Approach

**Precompute prefix max and suffix min:**
1. Build a `prefixMax` array where `prefixMax[i] = max(nums[0..i])`.
2. Build a `suffixMin` array where `suffixMin[i] = min(nums[i..n-1])`.
3. For each index `i`, the instability score is `prefixMax[i] - suffixMin[i]`.
4. Return the first index `i` where the instability score `<= k`.

Since `n <= 100` for this easy variant, a simple O(n^2) scan also works.

## Complexity

- Time: O(n) for the linear pass
- Space: O(n) for auxiliary arrays
