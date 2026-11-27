# Solution: 3419. Minimize the Maximum Edge Weight of Graph

**Link:** https://leetcode.com/problems/minimize-the-maximum-edge-weight-of-graph/

## Approach

Binary search on the answer (maximum edge weight W), combined with BFS/DFS feasibility check.

For a given weight W:
1. Keep only edges with weight <= W.
2. For each node except 0, it must have at least one outgoing edge with weight <= W within its threshold, leading towards node 0.
3. Check if all nodes can reach node 0 using at most `threshold` outgoing edges per node.

Feasibility: For each node (except 0), select the cheapest `threshold` outgoing edges with weight <= W. Then check if node 0 is reachable from all other nodes using BFS/DFS on the reverse graph.

Binary search range: [1, 10^6].

## Complexity

- Time: O(E log W log E) where W is max weight, E is number of edges
- Space: O(N + E)
