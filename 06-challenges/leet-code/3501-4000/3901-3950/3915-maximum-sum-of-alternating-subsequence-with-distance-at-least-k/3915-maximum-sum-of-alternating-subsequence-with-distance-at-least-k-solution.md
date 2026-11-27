# Solution for 3915. Maximum Sum of Alternating Subsequence With Distance at Least K

## Approach

**Dynamic Programming:**

Define:
- `up[i]` = max sum of an alternating subsequence ending at index `i` where `nums[i]` is a "local high" (previous element was lower).
- `down[i]` = max sum of an alternating subsequence ending at index `i` where `nums[i]` is a "local low" (previous element was higher).

Transitions (for `j = i - k` to 0):
- `up[i] = max(down[j] + nums[i])` for all valid `j` where `nums[j] < nums[i]`
- `down[i] = max(up[j] + nums[i])` for all valid `j` where `nums[j] > nums[i]`

**Optimization with segment trees / monotone structures:** To avoid O(n^2), maintain a segment tree or similar structure indexed by value to query the maximum `down[j]` for `j <= i - k` where `nums[j] < nums[i]`, and similarly for `up`.

**Using sorted structure:** 
- Maintain `maxDownBelow[v]` = max `down[j]` over all j processed so far (j <= i-k) with `nums[j] < v`.
- Use a Fenwick tree or segment tree indexed by compressed values.

**Base case:** Any single element: `up[i] = down[i] = nums[i]`.

## Complexity

- Time: O(n log n) with Fenwick tree
- Space: O(n)
