# 3486. Longest Special Path II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/longest-special-path-ii/

---

## Solution: DFS with Two-Pointer on Path — O(n log n) time, O(n) space

**Idea:** Perform a DFS from the root, maintaining the current root-to-node path as a list of (node, edgeLength). Track two pointers: `start1` (first duplicate constraint) and `start2` (second duplicate constraint). For each node value, track its last two occurrence positions on the current path. Use prefix sums for fast path length queries.

**Algorithm:**
1. Build adjacency list from edges.
2. DFS with current path and prefix length array.
3. For each node's value, check if it has appeared 1 or 2 times in the current path.
4. `start1` = max of previous occurrences (at most once allowed duplicate).
5. Valid path starts at `start2`; compute length and node count.
6. Update global best (length DESC, node count ASC).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
