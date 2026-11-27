# Solution for 3904. Smallest Stable Index II

## Approach

**Same algorithm as 3903, but with larger constraints (n up to 10^5), requiring O(n) approach:**

1. Build a `prefixMax` array in one left-to-right pass.
2. Build a `suffixMin` array in one right-to-left pass.
3. Iterate indices and return the first `i` where `prefixMax[i] - suffixMin[i] <= k`.

**Binary search optimization:** Since `prefixMax` is non-decreasing and `suffixMin` is non-increasing, the instability score `prefixMax[i] - suffixMin[i]` is non-decreasing. So we can binary search for the first index where score <= k.

## Complexity

- Time: O(n) with linear scan; O(n log n) with binary search (same asymptotically)
- Space: O(n)
