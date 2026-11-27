# 101. Symmetric Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/symmetric-tree/

---

## Solution 1: Recursive — O(n) time, O(h) space

**Idea:** A tree is symmetric if the left subtree is a mirror of the right subtree. Two subtrees are mirrors if their roots have the same value and each subtree's left child mirrors the other's right child.

**Algorithm:**
1. Define `isMirror(left, right)`:
   - If both are `null` → `true`.
   - If exactly one is `null` → `false`.
   - Return `left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left)`.
2. Return `isMirror(root.left, root.right)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) — recursion stack, h = tree height |

---

## Solution 2: Iterative (BFS) — O(n) time, O(n) space

**Idea:** Use a queue seeded with the two children of root. At each step dequeue a pair `(left, right)` and check mirror conditions, then enqueue `(left.left, right.right)` and `(left.right, right.left)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(n) — queue holds O(n) node pairs in the worst case |
