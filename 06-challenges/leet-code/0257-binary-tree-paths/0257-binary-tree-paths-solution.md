# 257. Binary Tree Paths — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-tree-paths/

---

## Solution 1: DFS Recursive — O(n) time, O(h) space

**Idea:** Recursively traverse from root to each leaf, building the path string. When a leaf is reached, add the complete path to the result list.

**Algorithm:**
1. If the node is a leaf, append `path + node.val` to results.
2. Otherwise, recurse left and right, appending `node.val + "->"` to the path.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(h) — recursion stack depth equals tree height |

---

## Solution 2: DFS Iterative — O(n) time, O(n) space

**Idea:** Use an explicit stack storing `(node, path)` pairs. Pop each node and either record the leaf path or push children with the extended path.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(n) — stack stores up to n path strings |
