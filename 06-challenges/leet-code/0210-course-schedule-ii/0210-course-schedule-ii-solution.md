# 210. Course Schedule II — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/course-schedule-ii/

---

## Solution: Kahn's Algorithm (BFS Topological Sort) — O(V + E) time, O(V + E) space

**Idea:** Courses with no prerequisites can be taken first. After "taking" a course, decrement the in-degree of its dependents; courses that reach in-degree 0 become available. If all courses are taken, return the order; otherwise a cycle exists.

**Algorithm:**
1. Build adjacency list and in-degree array from `prerequisites`.
2. Enqueue all courses with in-degree 0.
3. While queue non-empty: dequeue course `c`, append to result, decrement in-degree of each course that depends on `c`; enqueue newly zero-in-degree courses.
4. Return result if its length equals `numCourses`, else return `[]`.

**Complexity:**

| | |
|---|---|
| Time | O(V + E) — each node and edge processed once |
| Space | O(V + E) — adjacency list + queue |

---

## Solution 2: DFS Post-order — O(V + E) time, O(V + E) space

**Idea:** Run DFS. A node is appended to the result *after* all its dependencies are processed (post-order). Reverse the post-order list to get a valid topological order.

**Algorithm:**
1. For each unvisited node run `dfs(node)`.
2. In `dfs(node)`: mark as visiting; recurse on all neighbours (return empty on cycle); mark as done; push to stack.
3. Reverse and return the stack, or empty if a cycle was detected.

**Complexity:**

| | |
|---|---|
| Time | O(V + E) |
| Space | O(V + E) — stack + recursion depth |
