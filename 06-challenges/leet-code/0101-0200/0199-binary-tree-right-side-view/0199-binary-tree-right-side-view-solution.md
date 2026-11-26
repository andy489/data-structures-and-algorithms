# 199. Binary Tree Right Side View — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-right-side-view/

---

## Solution 1: BFS (level-order) — O(n) time, O(n) space

**Idea:** Process the tree level by level. The last node dequeued in each level is visible from the right side — add its value to the result.

**Algorithm:**
1. If root is null, return an empty list.
2. Add root to a queue.
3. While the queue is non-empty, process one full level:
   - Track the last node in the level.
   - Enqueue its non-null children.
4. Add the last node's value to the result list.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(n) — queue holds at most the width of the widest level |

---

## Solution 2: DFS (right-first preorder) — O(n) time, O(h) space

**Idea:** Traverse the tree recursively, visiting the right child before the left. Track the current depth. The first node encountered at each depth (which is the rightmost node at that depth) is added to the result.

**Algorithm:**
1. Recurse with `(node, depth)`.
2. If `result.size() == depth`, this is the first node seen at this depth — add its value.
3. Recurse on right child first (depth + 1), then left child (depth + 1).

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(h) — recursion stack depth equals tree height h (O(log n) balanced, O(n) worst) |
