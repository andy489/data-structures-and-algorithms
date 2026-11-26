# 116. Populating Next Right Pointers in Each Node — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

---

## Solution 1: BFS (level-order) — O(n) time, O(n) space

**Idea:** Process each level using a queue. Within a level, link each node's `next` to the following node in the queue; the last node in the level gets `null`.

**Algorithm:**
1. If `root` is null, return null.
2. Add `root` to a queue.
3. While the queue is non-empty, process one full level:
   - For each node in the level, set `node.next` to the next node in the queue (or `null` for the last).
   - Enqueue left and right children.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(n) — queue holds at most n/2 nodes (the last level of a perfect binary tree) |

---

## Solution 2: O(1)-space using already-set `next` pointers — O(n) time, O(1) space

**Idea:** Use the `next` pointers we've already established on level `k` to traverse level `k` and wire level `k+1`, without a queue. Because the tree is perfect, every node has two children.

**Algorithm:**
1. Start with `leftmost = root`.
2. While `leftmost.left != null` (i.e., not at the leaf level):
   - Traverse the current level via `head = leftmost`:
     - `head.left.next = head.right` (connect within same parent)
     - If `head.next != null`: `head.right.next = head.next.left` (connect across parents)
     - `head = head.next`
   - `leftmost = leftmost.left` (drop to next level)

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(1) — no auxiliary data structures; recursive stack not needed |

---

## Solution 3: Recursive — O(n) time, O(log n) space

**Idea:** At each node, wire the two inner connections (`node.left.next = node.right` and `node.left.right.next = node.right.left` if `node.next` exists), then recurse on children. Works cleanly because the tree is perfect.

**Algorithm:**
1. Base case: `node == null` or `node.left == null` → return.
2. `node.left.next = node.right`
3. If `node.next != null`: `node.right.next = node.next.left`
4. Recurse on `node.left` and `node.right`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(log n) — recursion depth equals tree height |
