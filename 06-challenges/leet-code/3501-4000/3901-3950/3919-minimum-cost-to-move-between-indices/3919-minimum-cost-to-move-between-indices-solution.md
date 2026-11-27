# Solution for 3919. Minimum Cost to Move Between Indices

## Approach

**Dijkstra's shortest path:**

Model the problem as a weighted graph where nodes are indices 0..n-1. For each pair of indices (x, y), we can move directly at cost `abs(nums[x] - nums[y])`. We can also move to `closest(x)` at cost 1.

**Precompute closest:** For each index x, `closest(x)` is the adjacent index (x-1 or x+1) minimizing `abs(nums[x] - nums[adj])`. Since `nums` is strictly increasing, `nums[x] - nums[x-1]` vs `nums[x+1] - nums[x]`; choose the smaller; if equal, choose x-1.

**Graph edges:**
- For each x: edge to `closest(x)` with cost 1.
- For each x, y: edge with cost `abs(nums[x] - nums[y])`.

Since direct edges dominate (O(n^2) edges), and n <= 10^4, we use Dijkstra per query or precompute all-pairs shortest paths.

**Optimization:** Note that the "closest" edges form a path graph with cost-1 edges. Combined with absolute-difference edges, Dijkstra from a source gives all distances. For q queries, run Dijkstra from each distinct l.

Since n, q <= 10^4, precomputing from all n sources may be costly. Instead run Dijkstra per unique source.

## Complexity

- Time: O(q * (n + n^2) * log n) or O(n^2 log n) with all-pairs Dijkstra
- Space: O(n^2)
