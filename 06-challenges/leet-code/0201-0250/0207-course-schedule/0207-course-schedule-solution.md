# 207. Course Schedule — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/course-schedule/

---

## Solution: DFS Cycle Detection (3-colour) — O(V + E) time, O(V + E) space

**Idea:** Model courses as a directed graph. A valid schedule exists if and only if the graph is acyclic. Use DFS with three states per node — unvisited (0), in-progress/visiting (1), done (2) — to detect back edges (cycles).

**Algorithm:**
1. Build adjacency list from `prerequisites`.
2. For each unvisited node, run `dfs(node)`.
3. In `dfs(node)`:
   - Mark node as visiting (1).
   - For each neighbour: if visiting → cycle found, return `false`; if unvisited → recurse.
   - Mark node as done (2). Return `true`.
4. If all DFS calls succeed, return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(V + E) — each node and edge visited once |
| Space | O(V + E) — adjacency list + recursion stack |

---

## Solution 2: Kahn's Algorithm (BFS Topological Sort) — O(V + E) time, O(V + E) space

**Idea:** Iteratively remove nodes with in-degree 0 (no prerequisites). If all nodes are removed, no cycle exists.

**Algorithm:**
1. Compute in-degree for every node.
2. Enqueue all nodes with in-degree 0.
3. While queue non-empty: dequeue a node, decrement in-degree of all its neighbours; enqueue any that reach 0. Count processed nodes.
4. Return `count == numCourses`.

**Complexity:**

| | |
|---|---|
| Time | O(V + E) |
| Space | O(V + E) |
