# 102. Binary Tree Level Order Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-level-order-traversal/

---

## Solution: BFS with Level Snapshot — O(n) time, O(n) space

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
