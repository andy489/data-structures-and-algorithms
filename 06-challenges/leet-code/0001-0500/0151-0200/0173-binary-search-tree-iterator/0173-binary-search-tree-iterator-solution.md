# 173. Binary Search Tree Iterator — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-search-tree-iterator/

---

## Solution 1: Controlled Stack (Morris-like lazy in-order) — O(1) avg time, O(h) space

**Idea:** Use an explicit stack pre-loaded with the leftmost spine. `next()` pops a node, pushes its right child's leftmost spine. Each node is pushed/popped exactly once, so `next()` is O(1) amortised.

**Algorithm:**

Constructor:
1. Push all nodes on the leftmost path starting from `root` onto the stack.

`next()`:
1. Pop the top node `curr`.
2. Push the entire leftmost spine of `curr.right` onto the stack.
3. Return `curr.val`.

`hasNext()`:
1. Return `!stack.isEmpty()`.

**Complexity:**

| | |
|---|---|
| Time | O(1) amortised per `next()` / `hasNext()` — each node pushed and popped once |
| Space | O(h) — at most h nodes on stack at any time (h = tree height) |

---

## Solution 2: Flattened List — O(n) init, O(1) per call, O(n) space

**Idea:** Perform a full in-order traversal at construction time, store results in a list, and use an index pointer.

**Algorithm:**
1. DFS in-order into an `ArrayList`.
2. `next()` returns `list.get(index++)`.
3. `hasNext()` returns `index < list.size()`.

**Complexity:**

| | |
|---|---|
| Time | O(n) construction, O(1) per `next()`/`hasNext()` |
| Space | O(n) |
