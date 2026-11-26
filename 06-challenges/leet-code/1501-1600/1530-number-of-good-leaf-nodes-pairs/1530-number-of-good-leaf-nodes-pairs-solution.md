# 1530. Number of Good Leaf Nodes Pairs — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

---

## Solution: Post-order DFS with Depth Arrays — O(n * distance) time, O(n * distance) space

**Idea:** At each node, return an array of depths of leaf nodes reachable from this node. When merging left and right subtrees, count pairs where the sum of depths <= distance. Then increment all depths by 1 as we return to the parent.

**Algorithm:**
1. Base case: null returns empty; leaf returns [1].
2. Recursively get depth lists from left and right children.
3. Count pairs where `left[i] + right[j] <= distance`.
4. Return merged list with each depth incremented by 1 (filtering out depths > distance).

**Complexity:**

| | |
|---|---|
| Time | O(n * distance) — at each node, we compare left × right depth lists bounded by distance |
| Space | O(n * distance) — depth lists in the call stack |
