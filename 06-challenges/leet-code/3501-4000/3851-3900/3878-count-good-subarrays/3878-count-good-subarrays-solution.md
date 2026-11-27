# Solution: 3878. Count Good Subarrays

## Approach

A subarray is good if its OR equals some element in it. Note that OR can only equal the maximum element in the subarray (since OR >= every element, so OR = max element means OR equals the max).

Key insight: `OR(subarray) >= max(subarray)`. Equality holds iff `OR = max`, which means all other elements are "subsets" of the max's bits (i.e., `a & max == a` for all `a` in subarray).

So a good subarray is one where every element's bits are a subset of the maximum element's bits.

For each right endpoint `r`, find the leftmost `l` such that `[l..r]` is good. As we extend right, the max can only increase or stay. Use a two-pointer / sliding window approach:

For each right `r`:
- Keep a window `[left, r]` where the subarray is good.
- When we add `nums[r]`, update the running OR and check if it still equals the max.
- Since OR only increases when extending left, track the minimum left where goodness holds.

Actually, use sliding window: maintain a window where OR == max. When OR > max (after extending), shrink from left.

Track elements in window to maintain max efficiently (use a sorted structure or deque for max).

For each valid right, count = r - left + 1.

## Complexity

- **Time:** O(n log n) with sorted set for max tracking
- **Space:** O(n)
