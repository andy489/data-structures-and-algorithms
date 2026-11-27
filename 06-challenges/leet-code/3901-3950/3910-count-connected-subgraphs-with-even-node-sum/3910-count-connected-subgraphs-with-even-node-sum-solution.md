# Solution for 3910. Count Connected Subgraphs with Even Node Sum

## Approach

**Bitmask enumeration (n <= 20):**

Since n is small (at most 20), we can enumerate all 2^n - 1 non-empty subsets.

For each subset:
1. Check if the induced subgraph is connected (BFS/DFS on the subset).
2. Check if the sum of node values is even.
3. If both conditions hold, increment the counter.

**Connectivity check for a subset:** Use BFS starting from any node in the subset, only traversing edges where both endpoints are in the subset. Check all subset nodes are reachable.

**Optimization:** Precompute adjacency for quick neighbor lookup. For each subset, extract nodes using bit operations.

## Complexity

- Time: O(2^n * n) for subset enumeration and connectivity checks
- Space: O(n) for BFS
