# 106. Construct Binary Tree from Inorder and Postorder Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

---

## Solution: Recursive DFS + HashMap — O(n) time, O(n) space

**Idea:** The last element of `postorder` is always the root of the current subtree. Find its index in `inorder` (O(1) with a prebuilt HashMap) to split the array into left and right subtrees. The left subtree has `leftSize` elements; use that to slice both arrays and recurse.

**Key insight — postorder slice sizes:**
- Left subtree postorder: `postorder[0 .. leftSize-1]`
- Right subtree postorder: `postorder[leftSize .. end-2]` (exclude last = current root)

**Algorithm:**
1. Precompute `inorderIndex` map: value → index in `inorder`.
2. Define `build(inL, inR, postL, postR)`:
   - If `inL > inR`, return `null`.
   - `rootVal = postorder[postR]`; create `root`.
   - `mid = inorderIndex[rootVal]`; `leftSize = mid - inL`.
   - Recurse: `root.left = build(inL, mid-1, postL, postL+leftSize-1)`
   - Recurse: `root.right = build(mid+1, inR, postL+leftSize, postR-1)`
3. Return `build(0, n-1, 0, n-1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once; HashMap lookup is O(1) |
| Space | O(n) — HashMap + O(h) recursion stack (O(n) worst case) |

---

## Solution 2: Iterative Stack — O(n) time, O(n) space

**Idea:** Mirror of the 0105 iterative solution. Process `postorder` **right-to-left** (root is last, so start from index `n-2` after creating the root) and traverse `inorder` **right-to-left**. Attach new nodes as **right children** by default; when the stack top matches `inorder[inorderIdx]`, pop until it doesn't — that last popped node needs a **left child**.

**Why right-to-left:** Postorder is `[left | right | root]`. Reading backwards gives `[root | right | left]`, which mirrors the preorder `[root | left | right]` logic — except we build right subtrees first.

**Algorithm:**
1. Create `root` from `postorder[n-1]`, push onto stack; set `inorderIdx = n-1`.
2. For `i` from `n-2` down to `0`:
   - Create `node = postorder[i]`.
   - If `stack.top.val != inorder[inorderIdx]`: attach as **right child** of top.
   - Else: pop stack while top matches `inorder[inorderIdx--]`; attach as **left child** of last popped.
   - Push `node`.
3. Return `root`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node pushed and popped at most once |
| Space | O(n) — stack depth proportional to tree height |
