# 501. Find Mode in Binary Search Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-mode-in-binary-search-tree/

---

## Solution: Morris In-order Traversal — O(n) time, O(1) space

**Idea:** In a BST, in-order traversal visits nodes in sorted order, so equal values are consecutive. Use Morris traversal to avoid recursion stack, tracking current run length vs maximum.

**Algorithm:**
1. Morris in-order: thread right child of predecessor to current node.
2. Track `prev` value, `curCount` (current run), `maxCount`.
3. When `curCount == maxCount` add to results; when `curCount > maxCount` reset results.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited twice |
| Space | O(1) — excluding output array |

---

## Solution 2: Recursive In-order — O(n) time, O(h) space

**Idea:** Recursive in-order traversal maintaining same count tracking. Simpler code at the cost of O(h) stack space.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(h) — recursion stack height |
