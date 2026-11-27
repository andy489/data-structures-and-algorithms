# 226. Invert Binary Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/invert-binary-tree/

---

## Solution: Recursive DFS — O(n) time, O(h) space

**Idea:** Swap the left and right children of every node recursively.

**Algorithm:**
1. Base case: if `root == null` return `null`.
2. Swap `root.left` and `root.right`.
3. Recurse on both children.
4. Return `root`.

## Solution 2: Iterative BFS — O(n) time, O(n) space

**Idea:** Level-order traversal with a queue; swap children as each node is dequeued.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit every node |
| Space | O(h) recursive (O(n) worst); O(n) iterative |
