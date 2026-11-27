# 1782. Count Pairs of Nodes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-pairs-of-nodes/

---

## Solution: Sorted Degrees + Two Pointers + Prefix Sums — O((n + m + q) log n) time, O(n + m) space

**Idea:** `incident(a, b) = deg[a] + deg[b] - shared[a][b]` where `shared[a][b]` is the number of edges between `a` and `b` directly. For each query `q`, we want pairs where `deg[a] + deg[b] > q + shared[a][b]`, which is `>= q + 1` before correction. First, count pairs where `deg[a] + deg[b] > q` using sorted degrees and two pointers / prefix sums, then subtract overcounts for edges where `deg[u] + deg[v] - shared[u][v] <= q` but `deg[u] + deg[v] > q`.

**Algorithm:**
1. Compute degree array `deg[1..n]`.
2. Count multi-edge frequency `shared[u][v]` using a hash map.
3. Sort degree values into array `sorted`.
4. Build a prefix sum over sorted degrees for fast counting.
5. For each query `threshold`:
   - Use two pointers on `sorted` to count pairs with `sorted[i] + sorted[j] > threshold`.
   - For each actual edge `(u, v)` with shared count, if `deg[u] + deg[v] > threshold` but `deg[u] + deg[v] - shared[u][v] <= threshold`, subtract those overcounted pairs.

**Complexity:**

| | |
|---|---|
| Time | O((n + m + q) log n) — sorting + two pointers per query |
| Space | O(n + m) — degree array and shared edge map |
