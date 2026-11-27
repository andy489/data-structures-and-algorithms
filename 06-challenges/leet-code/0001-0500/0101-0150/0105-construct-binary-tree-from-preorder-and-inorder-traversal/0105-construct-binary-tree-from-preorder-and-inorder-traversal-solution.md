# 105. Construct Binary Tree from Preorder and Inorder Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

---

## Solution 1: Recursive DFS with HashMap — O(n) time, O(n) space

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

---

## Solution 2: Iterative with Stack — O(n) time, O(h) space

**Idea:** Walk `preorder` left to right; each element is the next node to attach. A stack tracks nodes whose left subtree is still being processed. Compare the stack's top value against `inorder[inorderIdx]` to decide attachment side: if they differ, the new node is a left child; once they match, pop until they diverge — the last popped node receives the new node as its right child.

**Algorithm:**
1. Create `root` from `preorder[0]`, push it onto the stack, set `inorderIdx = 0`.
2. For `i` from `1` to `n-1`:
   - If `stack.peek().val != inorder[inorderIdx]`: attach `preorder[i]` as the left child of the top, push the new node.
   - Else: pop nodes while `stack` is non-empty and `stack.peek().val == inorder[inorderIdx]`, incrementing `inorderIdx` each time. Attach `preorder[i]` as the right child of the last popped node, push the new node.
3. Return `root`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node pushed and popped at most once |
| Space | O(h) — stack depth equals tree height; O(n) worst case for skewed tree |

