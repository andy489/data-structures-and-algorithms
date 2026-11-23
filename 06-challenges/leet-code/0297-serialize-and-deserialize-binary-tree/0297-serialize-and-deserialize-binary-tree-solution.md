# 297. Serialize and Deserialize Binary Tree — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

---

## Solution: Preorder DFS with Null Markers — O(n) time, O(n) space

**Idea:** Serialize with preorder DFS, writing each node's value and `#` for null children, separated by commas. Deserialize by reading tokens in the same preorder, reconstructing each node recursively.

**Algorithm:**
Serialize:
1. If null, append `#`.
2. Otherwise, append `node.val`, recurse left, recurse right.

Deserialize:
1. Split by delimiter into a queue of tokens.
2. Pop token: if `#`, return null; otherwise create a node and recursively build left and right subtrees.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node exactly once in both directions |
| Space | O(n) — recursion stack + serialized string |
