# 3373. Maximize the Number of Target Nodes After Connecting Trees II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/

---

## Solution: Bipartite 2-Coloring — O(n + m) time, O(n + m) space

**Idea:** Nodes at **even** distance from `v` in a tree are exactly the nodes with the **same color** as `v` in a 2-coloring (bipartite partition). Trees are always bipartite.

When we add an edge from node `i` (tree1) to node `j` (tree2), the path length from `i` to any tree2 node `w` is `1 + dist(j, w)`. For this to be even, `dist(j, w)` must be odd — i.e., `w` has the **opposite color** from `j`. To maximise, pick `j` such that the count of opposite-color nodes in tree2 is maximised, which equals `max(count0_in_tree2, count1_in_tree2)`.

For tree1: `answer[i] = count_of_same_color_in_tree1[color1[i]] + best2`.

**Algorithm:**
1. BFS-color both trees (assign 0/1 to each node by layer parity).
2. Count `c1[0]`, `c1[1]` for tree1 and `c2[0]`, `c2[1]` for tree2.
3. `best2 = max(c2[0], c2[1])`.
4. For each node `i`, `answer[i] = c1[color1[i]] + best2`.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — single BFS pass on each tree |
| Space | O(n + m) — adjacency lists + color arrays |
