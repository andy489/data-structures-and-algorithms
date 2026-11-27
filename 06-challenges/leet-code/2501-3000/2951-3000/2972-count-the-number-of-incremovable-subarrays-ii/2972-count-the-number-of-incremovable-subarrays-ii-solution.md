# Solution: Count the Number of Incremovable Subarrays II

## Approach: Two Pointers

Find the longest strictly increasing prefix (length `p`) and the longest strictly increasing suffix (length `s`).

For a subarray [i, j] to be incremovable:
- The prefix up to i-1 must be strictly increasing (i <= p)
- The suffix from j+1 must be strictly increasing (j >= n-s)
- If both prefix and suffix exist, the junction must also be valid: nums[i-1] < nums[j+1]

We iterate over all valid i values (from 0 to p), and for each i, find the range of valid j values using binary search.

## Complexity

| | Time | Space |
|---|---|---|
| **Two Pointers** | **O(n)** | **O(1)** |

## Key Insight

The left starting point i can range from 0 to p (where p is the increasing prefix length). For each i, j must start from at least some position in the suffix. Use two pointers: for increasing i, the minimum valid j is non-decreasing.
