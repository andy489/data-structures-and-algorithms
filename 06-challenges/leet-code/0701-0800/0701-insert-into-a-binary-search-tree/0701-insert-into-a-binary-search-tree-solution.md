# 701. Insert into a Binary Search Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/insert-into-a-binary-search-tree/

---

## Solution 1: Recursive — O(h) time, O(h) space

**Idea:** Traverse the BST recursively. If `val` is less than current node's value, recurse left; otherwise recurse right. When we reach null, return a new node with `val`.

**Algorithm:**
1. Base case: if `root` is null, return a new `TreeNode(val)`.
2. If `val < root.val`, recurse on the left subtree.
3. Otherwise recurse on the right subtree.
4. Return root.

**Complexity:**

| | |
|---|---|
| Time | O(h) — h is the height of the tree (O(log n) balanced, O(n) worst) |
| Space | O(h) — recursion stack |

---

## Solution 2: Iterative — O(h) time, O(1) space

**Idea:** Traverse iteratively keeping a pointer to the current node. When we find a null child on the correct side, attach the new node there.

**Algorithm:**
1. If root is null, return a new `TreeNode(val)`.
2. Set `curr = root`. Loop:
   - If `val < curr.val`: if left is null, attach new node and break; else go left.
   - Else: if right is null, attach new node and break; else go right.
3. Return root.

**Complexity:**

| | |
|---|---|
| Time | O(h) |
| Space | O(1) — no recursion stack |
