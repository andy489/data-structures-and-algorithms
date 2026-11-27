# 2096. Step-By-Step Directions From a Binary Tree Node to Another — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

---

## Solution: LCA + Path Finding — O(n) time, O(n) space

**Idea:** Find LCA. Path from start to LCA is all 'U'. Path from LCA to dest uses 'L'/'R'.

**Algorithm:**
1. Find path from root to start and to dest.
2. Remove common prefix (= LCA).
3. Replace start path with same-length 'U'.
4. Concatenate remaining.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
