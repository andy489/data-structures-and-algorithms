# 103. Binary Tree Zigzag Level Order Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

---

## Solution: BFS with Direction Flag — O(n) time, O(n) space

**Idea:** Standard BFS level-snapshot (same as LC 102), but maintain a boolean `leftToRight`. For even-numbered levels (0-indexed) collect values left-to-right; for odd levels insert each value at the front of a `LinkedList` to get right-to-left order in O(1) per insertion. Toggle the flag after each level.

**Algorithm:**
1. If `root` is null, return `[]`.
2. Initialise queue with `root`, `leftToRight = true`.
3. While queue non-empty:
   - Snapshot `size = queue.size()`, create an empty `LinkedList<Integer> level`.
   - Loop `size` times: dequeue node, add its value — `addLast` if `leftToRight`, `addFirst` if not — then enqueue non-null children.
   - Append `level` to result; toggle `leftToRight`.
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(n) — queue + result |
