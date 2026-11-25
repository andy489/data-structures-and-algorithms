# 753. Cracking the Safe — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cracking-the-safe/

---

## Solution: De Bruijn Sequence / Hierholzer's Eulerian Circuit — O(k^n) time, O(k^n) space

**Idea:** Model as a directed graph (de Bruijn graph). Each node is an (n-1)-digit string. An edge from `v` to `v[1:]d` represents appending digit `d`. An Eulerian circuit visits all edges (all n-digit combinations) exactly once. Use DFS (Hierholzer's) to find it.

**Algorithm:**
1. Start with node `"0"*(n-1)`.
2. DFS: for each digit `d` from `k-1` down to `0`, if edge `node+d` not visited, recurse on `node[1:]+d`.
3. Append current node to result on backtrack.
4. Reverse result, prepend `"0"*(n-1)`.

**Complexity:**

| | |
|---|---|
| Time | O(k^n) — visit each edge once |
| Space | O(k^n) — visited set + result |
