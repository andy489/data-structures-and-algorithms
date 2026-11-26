# 104. Maximum Depth of Binary Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-depth-of-binary-tree/

---

## Solution 1: DFS Recursive — O(n) time, O(h) space

**Idea:** The maximum depth of a tree rooted at `node` is 1 + the maximum of the depths of its left and right subtrees. Base case: a null node has depth 0.

**Algorithm:**
1. If `root` is null, return `0`.
2. Recursively compute `leftDepth = maxDepth(root.left)` and `rightDepth = maxDepth(root.right)`.
3. Return `1 + max(leftDepth, rightDepth)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) — recursion stack, O(log n) average / O(n) worst (skewed tree) |

---

## Solution 2: BFS Iterative — O(n) time, O(n) space

**Idea:** Standard level-order BFS. Each time we fully drain a level from the queue, increment a depth counter. The counter at the end equals the maximum depth.

**Algorithm:**
1. If `root` is null, return `0`.
2. Initialise queue with `root`, `depth = 0`.
3. While queue non-empty:
   - Snapshot `size = queue.size()`, increment `depth`.
   - Loop `size` times: dequeue node, enqueue non-null children.
4. Return `depth`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(n) — queue holds up to one full level |

---

## Solution 3: DFS Iterative (Explicit Stack) — O(n) time, O(h) space

**Idea:** Replaces the call stack with a heap-allocated `Deque`, avoiding stack-overflow risk on deeply skewed trees. Pairs each node with its current depth; track the running maximum.

**Algorithm:**
1. If `root` is null, return `0`.
2. Push `(root, 1)` onto two parallel stacks (`nodes`, `depths`).
3. While stacks non-empty:
   - Pop `node` and `d`; update `max = Math.max(max, d)`.
   - Push non-null right child with `d + 1`, then left child with `d + 1`.
4. Return `max`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) — stack holds at most one path from root to leaf |
