# 230. Kth Smallest Element in a BST — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/kth-smallest-element-in-a-bst/

---

## Solution: Iterative Inorder Traversal — O(H+k) time, O(H) space

**Idea:** Inorder traversal of a BST yields sorted values. Stop after visiting the k-th node.

**Algorithm:**
1. Use an explicit stack; push left spine.
2. Pop a node, decrement `k`; if `k == 0` return its value.
3. Push the right subtree's left spine.

## Solution 2: Recursive Inorder with Early Exit — O(n) time, O(H) space

**Idea:** Recursive inorder with a counter; stop recursion once found.

**Complexity:**

| | |
|---|---|
| Time | O(H + k) iterative |
| Space | O(H) — stack depth |
