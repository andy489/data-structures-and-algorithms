# 938. Range Sum of BST — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/range-sum-of-bst/

---

## Solution: DFS with BST Pruning — O(n) time, O(h) space

**Idea:** Recursively traverse BST; skip left subtree if node.val ≤ low, skip right if ≥ high. Add node.val if in range.

**Complexity:**

| | |
|---|---|
| Time | O(n) worst case, better in practice |
| Space | O(h) — recursion depth |
