# 3367. Maximize Sum of Weights after Edge Removals — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-sum-of-weights-after-edge-removals/

---

## Solution: Tree DP (DFS) — O(n log n) time, O(n) space

**Idea:** Root the tree at node 0 and do a post-order DFS. For each node `v` we return two values:
- `f0(v)` — maximum weight sum in `v`'s subtree assuming the edge from `v` to its parent is **not** kept (so `v` may use up to `k` child edges).
- `f1(v)` — maximum weight sum in `v`'s subtree assuming the edge from `v` to its parent **is** kept (so `v` may use up to `k-1` child edges).

For each child `c` with edge weight `w`, the **gain** of keeping that edge is `w + f1(c) - f0(c)`. We always start with `f0(c)` for all children, then greedily pick the top-gain children (those where the gain is positive) up to the allowed budget.

**Algorithm:**
1. Build adjacency list.
2. DFS from root 0 with parent tracking.
3. For each node `v` collect gains `g[i] = w_i + f1(c_i) - f0(c_i)` for each child.
4. `base = sum of f0(c_i) for all children`.
5. Sort gains descending; take positive gains greedily up to budget `k` (for `f0`) or `k-1` (for `f1`).
6. Answer is `f0(root)`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting gains per node; total work proportional to edges |
| Space | O(n) — recursion stack + adjacency list |
