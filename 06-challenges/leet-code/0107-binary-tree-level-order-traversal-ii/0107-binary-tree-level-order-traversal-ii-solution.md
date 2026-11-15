# 107. Binary Tree Level Order Traversal II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

---

## Solution: BFS with ArrayDeque (append then reverse) — O(n) time, O(n) space

**Idea:** Standard BFS level-order traversal using `ArrayDeque` as the queue. Levels are collected top-to-bottom into an `ArrayList`, then `Collections.reverse` flips the list in O(h) at the end. `ArrayDeque` is preferred over `LinkedList` — it avoids per-node heap allocation and has better cache locality.

**Algorithm:**
1. If `root` is `null`, return empty list.
2. Initialise `ArrayDeque` queue with `root` and an output `ArrayList`.
3. While the queue is non-empty:
   - Snapshot the current queue size (= nodes on this level).
   - Poll that many nodes, collect their values into a level list, offer their non-null children.
   - Append the level list to the output.
4. `Collections.reverse(result)` and return.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node enqueued and dequeued exactly once |
| Space | O(n) — queue holds at most one full level; output holds all n values |

---

## Solution 2: DFS (recursive, track depth) — O(n) time, O(n) space

**Idea:** DFS visits nodes top-to-bottom, tracking depth. Each node is placed into `result[depth]`. After the full DFS, `result` is in top-to-bottom order — reverse it once at the end. No queue needed; uses the call stack instead.

**Algorithm:**
1. Define `dfs(node, depth)`:
   - If `node` is `null`, return.
   - If `result.size() == depth`, add a new empty list (new level discovered).
   - Append `node.val` to `result[depth]`.
   - Recurse on left child with `depth + 1`, then right child with `depth + 1`.
2. Call `dfs(root, 0)`.
3. Reverse `result` and return.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(n) — output + O(h) call stack (O(n) worst case skewed tree) |
