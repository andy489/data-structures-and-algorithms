# 98. Validate Binary Search Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/validate-binary-search-tree/

---

## Solution: Bounded Recursion — O(n) time, O(h) space

**Idea:** For each node, pass down a valid value range `(min, max)`. A node is valid if its value is strictly within `(min, max)`. Recurse left with `max = node.val` and right with `min = node.val`. Start with `(-∞, +∞)` at the root.

**Algorithm:**
1. Define `validate(node, min, max)`.
2. Base case: `null` node returns `true`.
3. If `node.val <= min` or `node.val >= max`, return `false`.
4. Return `validate(node.left, min, node.val) && validate(node.right, node.val, max)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited exactly once |
| Space | O(h) — recursion stack depth equals tree height h; O(log n) balanced, O(n) worst |

---

## Solution 2: Iterative In-order Traversal — O(n) time, O(h) space

**Idea:** In-order traversal of a valid BST yields a strictly increasing sequence. Traverse iteratively and verify each visited value is strictly greater than the previously visited value.

**Algorithm:**
1. Use an explicit stack; maintain `prev = Long.MIN_VALUE`.
2. Push left spine, then pop and visit: if `node.val <= prev`, return `false`; update `prev = node.val`; push right.
3. If traversal completes without violation, return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited exactly once |
| Space | O(h) — stack depth equals tree height |
