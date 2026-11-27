# 1964. Find the Longest Valid Obstacle Course at Each Position — Solution

## Approach

This is a variant of Longest Non-Decreasing Subsequence (LNDS) for each prefix, computed in O(n log n) using a patience sorting-like approach.

Maintain an auxiliary array `tails` where `tails[i]` is the smallest tail of all non-decreasing subsequences of length `i+1`. For each obstacle:
- Find the rightmost position in `tails` that is <= current obstacle (upper bound search for <=).
- Insert/update at that position.
- Record the position + 1 as the answer for this index.

**Complexity:** O(n log n) time, O(n) space.
