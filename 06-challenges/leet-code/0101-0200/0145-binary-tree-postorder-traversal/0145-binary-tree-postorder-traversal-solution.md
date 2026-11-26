# 145. Binary Tree Postorder Traversal — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-tree-postorder-traversal/

---

## Solution: Reverse Preorder with Stack — O(n) time, O(n) space

**Idea:** Postorder (left → right → root) is the reverse of a modified preorder (root → right → left). Use a stack to do root → right → left traversal, collecting results, then reverse at the end. This reuses the iterative preorder trick from problem 144 with a minor tweak.

**Algorithm:**
1. If `root == null`, return empty list.
2. Push `root` onto the stack.
3. While stack is non-empty: pop `node`, prepend (or collect then reverse) `node.val`; push `node.left` then `node.right` (right pushed second so left is processed first in the reversed output).
4. Return reversed result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(n) — stack and result list each hold at most O(n) entries |

---

## Solution 2: Recursive DFS — O(n) time, O(h) space

**Idea:** Classic postorder recursion — recurse left, recurse right, then visit the current node.

**Algorithm:**
1. If `root == null`, return.
2. Recurse on `root.left`, then `root.right`.
3. Add `root.val` to result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) — call stack depth; O(log n) balanced, O(n) skewed |

---

## Solution 3: Iterative with Two Stacks — O(n) time, O(n) space

**Idea:** Use a main stack for traversal and an output stack to naturally build postorder. Push to the output stack (instead of directly to result) reverses the collection order without needing an explicit reverse step.

**Algorithm:**
1. If `root == null`, return empty list.
2. Push `root` onto `stack`.
3. While `stack` is non-empty: pop `node`, push to `out`; push `node.left` then `node.right` onto `stack`.
4. Pop all from `out` into result and return.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(n) — two stacks, each bounded by O(n) |

---

## Solution 4: Morris Postorder Traversal — O(n) time, O(1) space

**Idea:** Extend Morris traversal to postorder. The key insight: when we revisit a node (predecessor's right link already set), reversely output the right-boundary of the left subtree (from `curr.left` to the predecessor). After the full traversal, output the right-boundary of the whole tree.

**Algorithm:**
1. Create a dummy node with `dummy.left = root`.
2. Set `curr = dummy`.
3. While `curr != null`:
   - If `curr.left == null`: move `curr = curr.right`.
   - Else: find predecessor (rightmost in left subtree, stopping before looping back).
     - If `predecessor.right == null`: set `predecessor.right = curr`, move `curr = curr.left`.
     - Else (return visit): reverse-print nodes from `curr.left` to predecessor; restore `predecessor.right = null`; move `curr = curr.right`.
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each edge traversed at most twice |
| Space | O(1) — no extra data structures; output list excluded |
