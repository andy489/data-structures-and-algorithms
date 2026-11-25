# 889. Construct Binary Tree from Preorder and Postorder Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

---

## Solution: Recursive Divide-and-Conquer — O(n^2) time, O(n) space

**Idea:** preorder[0] is root. preorder[1] is left subtree root. Find preorder[1] in postorder; its index tells us the size of the left subtree. Recurse.

**Algorithm:**
1. Root = preorder[0].
2. If only one element, return leaf.
3. Left root = preorder[1]; find in postorder at index L.
4. Left subtree size = L + 1. Recurse on preorder[1..L+1] and postorder[0..L].
5. Right subtree: preorder[L+2..] and postorder[L+1..n-2].

**Complexity:**

| | |
|---|---|
| Time | O(n^2) worst case (use hash for O(n)) |
| Space | O(n) — recursion |
