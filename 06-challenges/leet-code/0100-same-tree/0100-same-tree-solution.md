# 100. Same Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/same-tree/

---

## Solution: Recursion — O(n) time, O(h) space

**Idea:** Two trees are the same iff their roots have equal values and their left and right subtrees are recursively the same. Base cases handle null nodes.

**Algorithm:**
1. If both nodes are `null`, return `true`.
2. If exactly one is `null`, or their values differ, return `false`.
3. Recursively check `isSameTree(p.left, q.left)` and `isSameTree(p.right, q.right)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node at most once (n = min of both tree sizes) |
| Space | O(h) — recursion stack depth equals tree height h |

---

## Solution 2: Iterative BFS — O(n) time, O(n) space

**Idea:** Use a queue of node pairs instead of the call stack. Dequeue one pair at a time, apply the same three checks, then enqueue the left and right child pairs. Avoids stack overflow on deeply skewed trees.

**Algorithm:**
1. Enqueue `(p, q)`.
2. While queue is non-empty, dequeue `(a, b)`:
   - Both null → continue.
   - One null or values differ → return `false`.
   - Enqueue `(a.left, b.left)` and `(a.right, b.right)`.
3. Return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node pair visited exactly once |
| Space | O(n) — queue holds up to one full level of paired nodes |

---

## Solution 3: Iterative DFS — O(n) time, O(h) space

**Idea:** Replace the queue with a stack. Otherwise identical to Solution 2 — push pairs, pop and check, push children. Traverses depth-first; space is bounded by tree height rather than width.

**Algorithm:**
1. Push `(p, q)` onto the stack.
2. While stack is non-empty, pop `(a, b)`:
   - Both null → continue.
   - One null or values differ → return `false`.
   - Push `(a.left, b.left)` and `(a.right, b.right)`.
3. Return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node pair visited exactly once |
| Space | O(h) — stack depth bounded by tree height h |
