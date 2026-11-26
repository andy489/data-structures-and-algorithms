# 1766. Tree of Coprimes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/tree-of-coprimes/

---

## Solution: DFS with Ancestor Tracking by Value — O(n * 50) time, O(n + 50) space

**Idea:** Since node values are bounded by 50, we can precompute which values in [1,50] are coprime with each value. During DFS, maintain a stack/list for each value v (1..50) that records the (node, depth) pairs of ancestors currently on the DFS path with that value. For each node, check all values coprime with `nums[node]` and pick the ancestor with greatest depth.

**Algorithm:**
1. Precompute `coprimes[v]` = list of values in [1..50] coprime with `v`.
2. Build adjacency list. Run iterative DFS from root 0.
3. Maintain `last[v]` = stack of `(nodeId, depth)` for each value `v` currently on path.
4. On entering node `u` at depth `d`:
   - For each value `c` coprime with `nums[u]`, check `last[c]`; take the deepest.
   - Push `(u, d)` onto `last[nums[u]]`.
5. On leaving node `u`: pop from `last[nums[u]]`.

**Complexity:**

| | |
|---|---|
| Time | O(n * 50) — for each node, check at most 50 coprime values |
| Space | O(n + 50) — DFS stack and per-value ancestor stacks |
