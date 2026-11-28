# 2924. Find Champion II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-champion-ii/

---

## Solution: In-Degree Count — O(n + m) time, O(n) space

**Idea:** The champion has no team stronger than it, meaning no incoming edges in the DAG. Count in-degrees for all nodes: if exactly one node has in-degree zero, that is the unique champion; otherwise return `-1`.

**Algorithm:**
1. Initialize an `inDegree` array of size `n` with zeros.
2. For each edge `[u, v]`, increment `inDegree[v]`.
3. Count nodes with `inDegree[i] == 0`; if exactly one exists, return it; else return `-1`.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(n) |
