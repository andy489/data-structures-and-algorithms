# 103. Binary Tree Zigzag Level Order Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

---

## Solution 1: BFS with Direction Flag — O(n) time, O(n) space

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

---

## Solution 2: DFS with Depth — O(n) time, O(n) space

**Idea:** Pre-order DFS passing the current depth. On first visit to a level (`depth == result.size()`) open a new `LinkedList`. For even depths append to the tail (left-to-right); for odd depths prepend to the head (right-to-left) — each insertion is O(1).

**Algorithm:**
1. Define `dfs(node, depth, result)`:
   - Base case: if `node` is null, return.
   - If `depth == result.size()`, add a new `LinkedList` to result.
   - Cast `result.get(depth)` to `LinkedList<Integer>`; use `addLast` if `depth` is even, `addFirst` if odd.
   - Recurse left with `depth + 1`, then right with `depth + 1`.
2. Call `dfs(root, 0, result)` and return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) stack + O(n) result — O(n) overall |
