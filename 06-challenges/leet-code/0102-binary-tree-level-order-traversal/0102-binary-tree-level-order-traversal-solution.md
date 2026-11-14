# 102. Binary Tree Level Order Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-level-order-traversal/

---

## Solution 1: BFS with Level Snapshot — O(n) time, O(n) space

**Idea:** Use a queue for standard BFS. Before processing each level, snapshot the current queue size — that tells us exactly how many nodes belong to this level. Dequeue that many nodes, collect their values, and enqueue their children.

**Algorithm:**
1. If `root` is null, return `[]`.
2. Initialise a queue with `root` and an empty result list.
3. While the queue is non-empty:
   - Record `size = queue.size()`.
   - Create an empty level list.
   - Loop `size` times: dequeue a node, add its value to the level list, enqueue its non-null children (left then right).
   - Append the level list to result.
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node enqueued and dequeued once |
| Space | O(n) — queue holds at most one full level (up to n/2 nodes for a complete tree) |

---

## Solution 2: DFS with Depth — O(n) time, O(n) space

**Idea:** Pre-order DFS, passing the current depth. When `depth == result.size()` we are visiting this level for the first time, so we open a new list. Each node appends its value to `result[depth]`.

**Algorithm:**
1. Define `dfs(node, depth, result)`:
   - Base case: if `node` is null, return.
   - If `depth == result.size()`, add a new empty list to result.
   - Append `node.val` to `result[depth]`.
   - Recurse left with `depth + 1`, then right with `depth + 1`.
2. Call `dfs(root, 0, result)` and return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) stack + O(n) result — O(n) overall; stack is O(log n) for balanced trees |
