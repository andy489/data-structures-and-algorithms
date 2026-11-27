# 1203. Sort Items by Groups Respecting Dependencies — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/

---

## Solution: Topological Sort (Two-Level) — O(n + m + E) time, O(n + m + E) space

**Idea:** Assign each ungrouped item its own unique group. Build a dependency graph at both item level and group level. Topological sort groups, then items within each group.

**Algorithm:**
1. Assign unique group IDs to -1 items.
2. Build intra-group item graph and inter-group graph.
3. Topological sort groups and items.
4. If cycle detected, return [].

**Complexity:**

| | |
|---|---|
| Time | O(n + m + E) |
| Space | O(n + m + E) |
