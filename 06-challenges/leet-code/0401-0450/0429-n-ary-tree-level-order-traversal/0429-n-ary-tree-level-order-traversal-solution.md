# 429. N-ary Tree Level Order Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/n-ary-tree-level-order-traversal/

---

## Solution: BFS with Queue — O(n) time, O(n) space

**Idea:** Standard BFS level-by-level using a queue. At each level, process all nodes currently in the queue, collecting their values and enqueuing their children.

**Algorithm:**
1. If root is null, return empty list.
2. Add root to queue.
3. While queue is non-empty: snapshot the current level size, process exactly that many nodes, collect values, enqueue all children.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(n) — queue holds at most one full level |
