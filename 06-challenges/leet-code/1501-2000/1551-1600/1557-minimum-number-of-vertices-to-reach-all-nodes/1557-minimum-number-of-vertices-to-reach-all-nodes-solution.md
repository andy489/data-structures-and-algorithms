# 1557. Minimum Number of Vertices to Reach All Nodes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

---

## Solution: Nodes With No Incoming Edge — O(n + e) time, O(n) space

**Idea:** In a DAG, any node with an incoming edge can be reached from another node. Only nodes with no incoming edges must be in the minimum starting set. Any node reachable from another doesn't need to be a source.

**Algorithm:**
1. Collect all nodes that have at least one incoming edge.
2. Return all nodes that have no incoming edge.

**Complexity:**

| | |
|---|---|
| Time | O(n + e) — iterate over all edges to find nodes with incoming edges |
| Space | O(n) — boolean/set to track nodes with incoming edges |
