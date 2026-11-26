# 1579. Remove Max Number of Edges to Keep Graph Fully Traversable — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

---

## Solution: Union-Find (Two DSUs) — O((n + e) * alpha) time, O(n) space

**Idea:** Maintain two separate Union-Find structures — one for Alice and one for Bob. Process type-3 (shared) edges first to maximize sharing. An edge is redundant if both endpoints are already connected in the respective graph. Count redundant edges as removable.

**Algorithm:**
1. Initialize two DSUs for Alice and Bob.
2. Process type-3 edges: union in both DSUs; if neither DSU connected new nodes, the edge is removable.
3. Process type-1 edges for Alice only; type-2 edges for Bob only. Count redundant ones.
4. If both graphs are fully connected (1 component), return removed count; else return -1.

**Complexity:**

| | |
|---|---|
| Time | O((n + e) * alpha) — essentially O(n + e) with Union-Find operations |
| Space | O(n) — two parent and rank arrays |
