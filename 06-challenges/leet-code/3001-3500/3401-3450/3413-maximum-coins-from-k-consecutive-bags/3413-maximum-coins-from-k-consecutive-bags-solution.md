# Solution: Maximum Coins From K Consecutive Bags

## Approach

Sort segments by left endpoint. Use a sliding window / prefix sums approach on the sorted segments.

The k consecutive positions form a window [L, L+k-1]. For each possible window position, we want to compute total coins from all segments fully inside [L, L+k-1] plus partial coins from segments at the edges.

**Two sweeps** (left-anchored and right-anchored):
1. For each segment's left endpoint as the window start (L = segment[i].left), compute coins for [L, L+k-1].
2. For each segment's right endpoint as the window end (R = segment[i].right, L = R-k+1), compute coins for [L, L+k-1].

This covers all optimal windows since the optimal window is either bounded by some segment's left endpoint or some segment's right endpoint.

For each candidate window, use binary search + prefix sums to efficiently compute the total.

Prefix sum on segments: sort by left. For window [L, R=L+k-1]:
- Find all segments fully contained: [li, ri] where li >= L and ri <= R.
- For boundary segments: partial coverage.

## Complexity

| | Complexity |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
