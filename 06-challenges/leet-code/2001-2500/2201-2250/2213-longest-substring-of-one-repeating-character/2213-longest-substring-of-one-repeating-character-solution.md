# 2213. Longest Substring of One Repeating Character

## Approach

Use a Segment Tree where each node stores:
- The length of the longest run in the range.
- The length of the prefix run (starting character and length).
- The length of the suffix run (ending character and length).

When merging two segments, the longest run is the max of:
- Left longest run
- Right longest run
- Left suffix run + Right prefix run (if they have the same character)

For each query, update the character at position i, then query the root for the global longest run.

**Time Complexity:** O((n + k) log n) where k is the number of queries  
**Space Complexity:** O(n)
