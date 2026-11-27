# 2203. Minimum Weighted Subgraph With the Required Paths

## Approach

The key insight: the optimal subgraph consists of two paths (src1 → meeting_node and src2 → meeting_node) plus a path (meeting_node → dest). The meeting node can be any node v.

**Algorithm:**
1. Run Dijkstra from src1 on the original graph → dist1[v].
2. Run Dijkstra from src2 on the original graph → dist2[v].
3. Build reversed graph, run Dijkstra from dest → distDest[v].
4. Answer = min over all v of (dist1[v] + dist2[v] + distDest[v]).

This covers all cases: if src1 and src2 share a common intermediate node before reaching dest, or if their paths merge at some node v.

**Time Complexity:** O((V + E) log V) for three Dijkstra runs  
**Space Complexity:** O(V + E)
