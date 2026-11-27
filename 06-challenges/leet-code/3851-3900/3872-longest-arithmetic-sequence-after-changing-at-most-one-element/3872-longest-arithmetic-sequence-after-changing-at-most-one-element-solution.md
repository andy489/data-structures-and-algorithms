# Solution: 3872. Longest Arithmetic Sequence After Changing At Most One Element

## Approach

Use dynamic programming with two arrays:
- `dp0[i]` = length of longest arithmetic subarray ending at index `i` with **no** changes used
- `dp1[i]` = length of longest arithmetic subarray ending at index `i` with **one** change used

For each index `i >= 2`, compute differences:
- `d1 = nums[i] - nums[i-1]` (last diff)
- `d2 = nums[i-1] - nums[i-2]` (second last diff)
- `d3 = nums[i] - nums[i-2]` (what the diff would be if nums[i-1] is replaced)

Transitions:
- If `d1 == d2`: `dp0[i] = dp0[i-1] + 1`, `dp1[i] = dp1[i-1] + 1`
- If `d1 != d2`: `dp0[i] = 2`, `dp1[i] = dp0[i-1] + 1` (replace nums[i-1] to fit d1 from d2 context, or keep it)
- Also check if replacing nums[i] fits: `dp1[i] = max(dp1[i], 2)`
- If `d3 == 2 * d1` or related: consider replacing middle element

The key insight: when differences mismatch, we can either replace nums[i] (chain continues from dp0[i-1] with 1 edit), or replace nums[i-1] to match the previous sequence (dp0[i-2] + 2 if d3 == 2*d2).

Track maximum over all dp values, and the answer includes edge cases where the entire array can be one arithmetic sequence.

## Complexity

- **Time:** O(n)
- **Space:** O(1) (rolling variables)
