# 100. Same Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/same-tree/

---

## Solution: Recursion — O(n) time, O(h) space

**Idea:** Two trees are the same iff their roots have equal values and their left and right subtrees are recursively the same. Base cases handle null nodes.

**Algorithm:**
1. If both nodes are `null`, return `true`.
2. If exactly one is `null`, or their values differ, return `false`.
3. Recursively check `isSameTree(p.left, q.left)` and `isSameTree(p.right, q.right)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node at most once (n = min of both tree sizes) |
| Space | O(h) — recursion stack depth equals tree height h |
