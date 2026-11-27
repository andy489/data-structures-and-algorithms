# 1627. Graph Connectivity With Threshold — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/graph-connectivity-with-threshold/

---

## Solution: Sieve + Union-Find — O(n log n + q * α(n)) time, O(n) space

**Idea:** Instead of building edges one by one, use a sieve: for each divisor `z > threshold`, union all multiples of `z` together (since they all share `z` as a common divisor and are thus connected). Then answer queries with Union-Find.

**Algorithm:**
1. Initialize Union-Find on `n + 1` nodes.
2. For each `z` from `threshold + 1` to `n`:
   - For each multiple `m = 2z, 3z, ...` up to `n`: union `z` with `m`.
3. For each query `(a, b)`: answer is `find(a) == find(b)`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n + q * α(n)) — sieve is O(n log n), queries near O(1) each with path compression |
| Space | O(n) — Union-Find arrays |
