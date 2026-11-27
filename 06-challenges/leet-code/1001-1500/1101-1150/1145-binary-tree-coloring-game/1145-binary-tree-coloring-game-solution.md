# 1145. Binary Tree Coloring Game — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-coloring-game/

---

## Solution: Tree Partition Analysis — O(n) time, O(h) space

**Idea:** Once player 1 picks node `x`, the tree is split into at most 3 regions: the left subtree of `x`, the right subtree of `x`, and the "parent side" (all other nodes). Player 2 wins if and only if they can choose a node adjacent to `x` that controls a region with more than `n/2` nodes. The three region sizes are:
- `left`: size of `x`'s left subtree
- `right`: size of `x`'s right subtree
- `parent`: `n - left - right - 1`

Player 2 wins if any of these regions has more than `n/2` nodes.

**Algorithm:**
1. DFS to count the subtree size of `x` and record `left` and `right`.
2. Compute `parent = n - left - right - 1`.
3. Return `true` if `max(left, right, parent) > n / 2`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single DFS |
| Space | O(h) — recursion stack, h = tree height |
