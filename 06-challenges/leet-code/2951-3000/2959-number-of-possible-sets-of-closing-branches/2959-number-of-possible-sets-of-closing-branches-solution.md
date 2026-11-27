# 2959. Number of Possible Sets of Closing Branches — Solution

## Approach: Bitmask Enumeration + Floyd-Warshall

Since `n <= 10`, we can enumerate all 2^n subsets of open branches. For each subset, run Floyd-Warshall on the induced subgraph to compute all-pairs shortest paths. If all pairwise distances among active branches are <= maxDistance, count this subset.

**Algorithm:**
1. For each bitmask `mask` (0 to 2^n - 1) representing the set of CLOSED branches:
   - Determine active branches = {i : bit i not set in mask}.
   - Build adjacency matrix for active branches (initialize INF, 0 on diagonal).
   - Add all roads between active branches.
   - Run Floyd-Warshall.
   - Check if all pairs of active branches have dist <= maxDistance.
   - If yes, increment answer.

Note: the empty set of active branches (all closed) is always valid.

## Complexity

| | Time | Space |
|---|---|---|
| 2^n * (n^3 Floyd-Warshall) | O(2^n * n^3) | O(n^2) |

With n=10: 1024 * 1000 ≈ 10^6 — well within limits.
