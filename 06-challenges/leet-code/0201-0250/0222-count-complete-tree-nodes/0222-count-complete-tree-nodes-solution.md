# 222. Count Complete Tree Nodes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-complete-tree-nodes/

---

## Solution: Binary Search on Last Level — O(log²n) time, O(log n) space

**Idea:** A complete binary tree of height `h` has between `2^(h-1)` and `2^h - 1` nodes. Measure the height of the left spine and the right spine. If they're equal, the tree is perfect: return `2^h - 1`. Otherwise recursively count left and right subtrees, knowing one is perfect.

**Algorithm:**
1. `leftHeight(root)`: count steps along left spine.
2. `rightHeight(root)`: count steps along right spine.
3. If equal → return `(1 << h) - 1` (perfect subtree).
4. Otherwise return `1 + countNodes(root.left) + countNodes(root.right)`.

**Complexity:**

| | |
|---|---|
| Time | O(log²n) — O(log n) recursion levels, each O(log n) height computation |
| Space | O(log n) — recursion stack |
