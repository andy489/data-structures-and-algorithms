# 449. Serialize and Deserialize BST — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/serialize-and-deserialize-bst/

---

## Solution: Preorder Traversal — O(n) time, O(n) space

**Idea:** Serialize with preorder traversal (root, left, right) as space-separated integers. Deserialize by rebuilding the BST from the preorder sequence: the first element is the root, left subtree uses values < root, right subtree uses values > root. Use a queue for O(1) dequeuing.

**Algorithm:**
1. **Serialize:** DFS preorder, append node values separated by spaces.
2. **Deserialize:** Split string into queue of integers. Recursively build: `deserialize(queue, min, max)` takes the front element only if it falls within `(min, max)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(n) — string + recursion stack |
