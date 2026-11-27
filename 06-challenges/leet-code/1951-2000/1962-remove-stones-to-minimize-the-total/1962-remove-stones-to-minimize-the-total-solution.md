# 1962. Remove Stones to Minimize the Total — Solution

## Approach

Use a max-heap. Greedily always pick the pile with the most stones and reduce it by floor(size / 2). After k operations, sum all remaining piles.

**Complexity:** O(n + k * log n) time, O(n) space.
