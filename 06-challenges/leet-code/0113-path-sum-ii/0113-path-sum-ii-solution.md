# 113. Path Sum II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/path-sum-ii/

---

## Solution: DFS Backtracking — O(n²) time, O(h) space

**Idea:** DFS down each root-to-leaf path, carrying a running path list and the remaining sum. At a leaf, if `remaining == 0` snapshot the current path into the result. Backtrack by removing the last element after each recursive call so the same list is reused across all branches.

**Algorithm:**
1. Define `dfs(node, remaining, path, result)`.
2. If `node == null`, return.
3. Append `node.val` to `path`; subtract `node.val` from `remaining`.
4. If leaf and `remaining == 0`, add a copy of `path` to `result`.
5. Recurse on left and right children.
6. Remove the last element of `path` (backtrack).
7. Call `dfs(root, targetSum, [], result)` and return `result`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — O(n) nodes visited; copying a path at a leaf costs O(h) each; up to O(n/2) leaves in a balanced tree |
| Space | O(h) — recursion stack + path list, both bounded by tree height; O(n) worst case skewed |

---

## Solution 2: Iterative DFS with Explicit Stack — O(n²) time, O(n) space

**Idea:** Use a stack of `(node, remaining, path)` triples. When a leaf is popped with `remaining == 0`, record the path. Avoids recursion entirely.

**Algorithm:**
1. If `root == null`, return empty list.
2. Push `(root, targetSum - root.val, [root.val])` onto the stack.
3. While stack is non-empty: pop `(node, remaining, path)`.
   - If leaf and `remaining == 0`, add `path` to result.
   - For each non-null child, push `(child, remaining - child.val, path + [child.val])`.
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — same leaf-copy cost as recursive approach |
| Space | O(n·h) — stack may hold O(n) entries each carrying a path of length O(h) |
