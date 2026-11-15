# 107. Binary Tree Level Order Traversal II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

---

## Solution: BFS with ArrayDeque (addFirst, no reverse) — O(n) time, O(n) space

**Idea:** Use `ArrayDeque` for both the BFS queue and the result container. Each completed level is prepended with `addFirst` — O(1) amortised — so the result is already in bottom-to-top order when the BFS finishes. No `Collections.reverse` needed. The final `new ArrayList<>(result)` wraps the deque into the required `List` return type.

**Algorithm:**
1. If `root` is `null`, return empty list.
2. Initialise `ArrayDeque` queue with `root` and a `result` deque.
3. While the queue is non-empty:
   - Snapshot the current queue size (= nodes on this level).
   - Poll that many nodes, collect their values into a level list, offer their non-null children.
   - `result.addFirst(level)`.
4. Return `new ArrayList<>(result)`.

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
