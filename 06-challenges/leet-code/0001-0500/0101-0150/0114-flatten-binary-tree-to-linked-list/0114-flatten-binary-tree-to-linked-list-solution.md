# 114. Flatten Binary Tree to Linked List — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

---

## Solution 1: Post-order Recursion — O(n) time, O(h) space

**Idea:** Recursively flatten the left and right subtrees, then rewire: splice the flattened left list between the root and the flattened right list.

**Algorithm:**
1. Base case: if `node` is null or a leaf, return.
2. Recursively `flatten(node.left)` and `flatten(node.right)`.
3. Save `node.right` as `right`.
4. Set `node.right = node.left`, `node.left = null`.
5. Walk to the tail of the newly attached left chain; set `tail.right = right`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(h) — recursion stack; O(log n) balanced, O(n) worst case |

---

## Solution 2: Morris-like In-place — O(n) time, O(1) space

**Idea:** Iterate top-down. For each node that has a left child, find the rightmost node of the left subtree (the predecessor in pre-order), hook the current right subtree onto it, then swing the left subtree to the right and clear the left pointer. Repeat until no left children remain.

**Algorithm:**
1. While `curr` is not null:
   - If `curr.left` is null: advance `curr = curr.right`.
   - Otherwise: find `pred` = rightmost node of `curr.left`.
   - Set `pred.right = curr.right`.
   - Set `curr.right = curr.left`, `curr.left = null`.
   - Advance `curr = curr.right`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node is visited at most twice (once as curr, once as pred) |
| Space | O(1) — no recursion or auxiliary data structures |

---

## Solution 3: Explicit Stack (Iterative Pre-order) — O(n) time, O(h) space

**Idea:** Simulate pre-order traversal with an explicit stack. At each step, pop the current node, wire it as the right child of the previous node (clearing left), and push its right then left children so the left is processed next.

**Algorithm:**
1. If `root` is null, return.
2. Push `root` onto a stack. Maintain a `prev` pointer (initially null).
3. While the stack is not empty:
   - Pop `curr`.
   - If `prev` is not null: set `prev.right = curr`, `prev.left = null`.
   - Push `curr.right` (if non-null), then `curr.left` (if non-null).
   - Set `prev = curr`.
4. Clear `prev.left` after the loop (the last node).

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node pushed and popped once |
| Space | O(h) — stack holds at most one path worth of right children |
