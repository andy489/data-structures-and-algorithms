# 3372. Maximize the Number of Target Nodes After Connecting Trees I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/

---

## Solution: BFS from Each Node — O(n·m) time, O(n + m) space

**Idea:** When connecting node `i` in tree1 to node `j` in tree2 via one new edge, the nodes reachable from `i` within distance `k` are:
1. Nodes in tree1 within distance `k` from `i`.
2. Nodes in tree2 within distance `k - 1` from `j` (the extra edge costs 1).

To maximise, for each `i` we pick the `j` that maximises count in tree2 within `k-1`. Precompute `best2 = max over j of count(tree2, j, k-1)`. Then `answer[i] = count(tree1, i, k) + best2`.

**Algorithm:**
1. Build adjacency lists for both trees.
2. For each node in tree2, BFS to count nodes within `k-1` edges; track the global maximum `best2`.
3. For each node `i` in tree1, BFS to count nodes within `k` edges. Set `answer[i] = count + best2`.
4. Return `answer`.

**Complexity:**

| | |
|---|---|
| Time | O(n·(n+m) + m·m) — BFS from every node; n,m ≤ 1000 so ~10^6 |
| Space | O(n + m) — adjacency lists + BFS queue |
