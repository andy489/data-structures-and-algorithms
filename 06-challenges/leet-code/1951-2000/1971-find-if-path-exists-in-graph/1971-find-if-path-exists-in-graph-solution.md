# 1971. Find if Path Exists in Graph — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-if-path-exists-in-graph/

---

## Solution: Union-Find — O(n + e * α(n)) time, O(n) space

**Idea:** Use Union-Find to union all edges. Then check if `source` and `destination` share the same root.

**Algorithm:**
1. Initialize parent array where `parent[i] = i`.
2. For each edge `[u, v]`, union `u` and `v`.
3. Return `find(source) == find(destination)`.

**Complexity:**

| | |
|---|---|
| Time | O((n + e) · α(n)) |
| Space | O(n) |
