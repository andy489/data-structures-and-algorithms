# 117. Populating Next Right Pointers in Each Node II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

---

## Solution 1: BFS (level-order) — O(n) time, O(n) space

**Idea:** Same as problem 116 — process one full level at a time using a queue, linking consecutive nodes within each level.

**Algorithm:**
1. If root is null, return null.
2. Add root to a queue.
3. While the queue is non-empty, process one full level:
   - For each node, set `node.next` to the next node in the queue (or null for the last).
   - Enqueue non-null children.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(n) — queue holds at most the width of the widest level |

---

## Solution 2: O(1)-space dummy-head level traversal — O(n) time, O(1) space

**Idea:** Use a dummy node as the head of the next level's linked list. For each node on the current level (traversed via `next` pointers), attach its non-null children to the dummy list being built. When the current level is exhausted, drop down to `dummy.next` as the start of the next level.

**Algorithm:**
1. `curr = root`
2. While `curr != null`:
   - Create `dummy` (sentinel for next level) and `tail = dummy`.
   - While `curr != null`:
     - If `curr.left != null`: `tail.next = curr.left; tail = tail.next`
     - If `curr.right != null`: `tail.next = curr.right; tail = tail.next`
     - `curr = curr.next`
   - `curr = dummy.next` (drop to next level)

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node once |
| Space | O(1) — only a dummy sentinel and a few pointers per level |
