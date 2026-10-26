# 133. Clone Graph

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/clone-graph/

---

## Problem Statement

Given a reference of a node in a **connected** undirected graph, return a **deep copy** (clone) of the graph.

Each node in the graph contains a value (`int`) and a list (`List[Node]`) of its neighbors.

```
class Node {
    public int val;
    public List<Node> neighbors;
}
```

---

## Examples

**Example 1:**
```
Input:  adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
```
Node 1 ↔ 2, 1 ↔ 4, 2 ↔ 3, 3 ↔ 4 (a 4-cycle).

**Example 2:**
```
Input:  adjList = [[]]
Output: [[]]
```
A single node with no neighbors.

**Example 3:**
```
Input:  adjList = []
Output: []
```
Empty graph — `node` is `null`.

---

## Constraints

- The number of nodes in the graph is in the range `[0, 100]`
- `1 <= Node.val <= 100`
- `Node.val` is unique for each node
- There are no repeated edges and no self-loops
- The graph is connected, and all nodes can be visited starting from the given node
