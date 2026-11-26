# 606. Construct String from Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-string-from-binary-tree/

---

## Solution: DFS Recursion — O(n) time, O(n) space

**Idea:** Recursively build the string in preorder. After the root value, add left child in parentheses if it exists or if right child exists (empty parens needed). Add right child in parentheses if it exists.

**Algorithm:**
1. If node is null, return empty string.
2. Start with node's value.
3. If left is non-null OR right is non-null: append `"(" + dfs(left) + ")"`.
4. If right is non-null: append `"(" + dfs(right) + ")"`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits each node once |
| Space | O(n) — recursion stack + result string |
