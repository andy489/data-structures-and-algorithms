# Solution for 3912. Valid Elements in an Array

## Approach

**Precompute prefix max and suffix max:**

1. Compute `prefixMax[i]` = max of `nums[0..i-1]` (max of elements strictly to the left).
2. Compute `suffixMax[i]` = max of `nums[i+1..n-1]` (max of elements strictly to the right).
3. For each index `i`:
   - Valid if `nums[i] > prefixMax[i]` (greater than all to the left), OR
   - Valid if `nums[i] > suffixMax[i]` (greater than all to the right).
4. First and last elements are always valid.

## Complexity

- Time: O(n)
- Space: O(n)
