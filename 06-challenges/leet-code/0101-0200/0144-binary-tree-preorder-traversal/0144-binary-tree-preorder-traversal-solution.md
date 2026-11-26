# 144. Binary Tree Preorder Traversal — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-tree-preorder-traversal/

---

## Solution: Iterative DFS with Stack — O(n) time, O(n) space

**Idea:** Simulate preorder (root → left → right) with an explicit stack. Push root, then repeatedly pop, record the value, and push right child before left child — since stack is LIFO, left will be processed first.

**Algorithm:**
1. If `root == null`, return empty list.
2. Push `root` onto the stack.
3. While stack is non-empty: pop `node`, add `node.val` to result; push `node.right` if non-null; push `node.left` if non-null.
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node is visited exactly once |
| Space | O(n) — stack holds at most O(h) nodes; O(n) worst case (skewed tree) |

---

## Solution 2: Recursive DFS — O(n) time, O(h) space

**Idea:** Classic preorder recursion — visit the current node, recurse left, recurse right.

**Algorithm:**
1. If `root == null`, return.
2. Add `root.val` to result.
3. Recurse on `root.left`, then `root.right`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) — call stack depth; O(log n) balanced, O(n) skewed |

---

## Solution 3: Morris Preorder Traversal — O(n) time, O(1) space

**Idea:** Morris traversal modifies the tree temporarily to avoid extra space. For each node: if it has no left child, record it and move right; otherwise find its in-order predecessor (rightmost node in left subtree), link its right pointer back to current, record current, then move left. On the return visit, restore the link and move right.

**Algorithm:**
1. Set `curr = root`.
2. While `curr != null`:
   - If `curr.left == null`: add `curr.val`, move `curr = curr.right`.
   - Else: find predecessor (rightmost in left subtree, stopping before looping back to `curr`).
     - If `predecessor.right == null`: record `curr.val`, set `predecessor.right = curr`, move `curr = curr.left`.
     - Else (already linked — return visit): restore `predecessor.right = null`, move `curr = curr.right`.
3. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each edge traversed at most twice |
| Space | O(1) — no extra data structures; output list excluded |
