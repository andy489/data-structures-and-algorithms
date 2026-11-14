# 105. Construct Binary Tree from Preorder and Inorder Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

---

## Solution: Recursive DFS with HashMap — O(n) time, O(n) space

**Idea:** The first element of `preorder` is always the root. Locate that root in `inorder` — everything to its left belongs to the left subtree, everything to the right belongs to the right subtree. Recurse with the corresponding slices of `preorder` and `inorder`. Store index positions in a HashMap to avoid O(n) scans on each call.

**Algorithm:**
1. Build a HashMap from value → index for `inorder`.
2. Define `build(preL, preR, inL, inR)`:
   - If `preL > preR`, return `null`.
   - Root value = `preorder[preL]`; look up its index `mid` in the HashMap.
   - Left subtree size = `mid - inL`.
   - Recursively build left child from `preorder[preL+1 .. preL+leftSize]` and `inorder[inL .. mid-1]`.
   - Recursively build right child from `preorder[preL+leftSize+1 .. preR]` and `inorder[mid+1 .. inR]`.
3. Return `build(0, n-1, 0, n-1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once; HashMap lookup is O(1) |
| Space | O(n) — HashMap + recursion stack (O(h), worst O(n) for skewed tree) |
