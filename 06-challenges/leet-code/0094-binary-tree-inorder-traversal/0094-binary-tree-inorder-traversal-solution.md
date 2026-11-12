# 94. Binary Tree Inorder Traversal — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-tree-inorder-traversal/

---

## Solution: Iterative with explicit stack — O(n) time, O(n) space

**Idea:** Simulate the call stack of recursive inorder traversal explicitly. Walk left as far as possible pushing nodes; when you can't go left, pop, record the value, then move right.

**Algorithm:**
1. Initialize an empty stack and `curr = root`.
2. While `curr != null` or the stack is non-empty:
   - Push `curr` and descend left until `curr == null`.
   - Pop the top node, add its value to the result.
   - Move `curr` to the popped node's right child.
3. Return the result list.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node is pushed and popped exactly once |
| Space | O(n) — stack holds at most the height of the tree; O(n) worst case (skewed) |

---

## Solution 2: Recursive — O(n) time, O(n) space

**Idea:** Standard recursive inorder: left subtree → root → right subtree.

**Algorithm:**
1. Define `dfs(node)`: if `node == null` return; call `dfs(node.left)`, append `node.val`, call `dfs(node.right)`.
2. Call `dfs(root)` and return the accumulated list.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(n) — implicit call stack depth equals tree height |
