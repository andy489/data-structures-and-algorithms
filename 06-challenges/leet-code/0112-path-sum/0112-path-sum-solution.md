# 112. Path Sum — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/path-sum/

---

## Solution: DFS Recursive — O(n) time, O(h) space

**Idea:** Subtract each node's value from `targetSum` as we recurse down. At a leaf, check if the remaining sum equals the leaf's value (equivalently, if `targetSum - node.val == 0`). This avoids carrying a running sum — we reduce the problem at every step.

**Algorithm:**
1. If `root == null`, return `false`.
2. Subtract `root.val` from `targetSum`.
3. If `root` is a leaf (`left == null && right == null`), return `targetSum == 0`.
4. Return `hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node is visited at most once |
| Space | O(h) — recursion stack depth; O(log n) balanced, O(n) skewed |

---

## Solution 2: Iterative DFS with (node, remainingSum) Stack — O(n) time, O(h) space

**Idea:** Simulate the recursion with an explicit stack of `(node, remaining)` pairs. When a leaf is popped with `remaining == 0`, a valid path exists.

**Algorithm:**
1. If `root == null`, return `false`.
2. Push `(root, targetSum - root.val)` onto the stack.
3. While stack is non-empty: pop `(node, remaining)`; if leaf and `remaining == 0`, return `true`; push non-null children with `remaining - child.val`.
4. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited at most once |
| Space | O(h) — stack bounded by tree height |

---

## Solution 3: BFS with (node, remainingSum) Queue — O(n) time, O(w) space

**Idea:** Level-order traversal carrying the remaining sum alongside each node. When a leaf is dequeued with `remaining == 0`, a valid path exists.

**Algorithm:**
1. If `root == null`, return `false`.
2. Enqueue `(root, targetSum - root.val)`.
3. While queue is non-empty: dequeue `(node, remaining)`; if leaf and `remaining == 0`, return `true`; enqueue non-null children with `remaining - child.val`.
4. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited at most once |
| Space | O(w) — queue holds at most one level; O(n) worst case (complete tree) |
