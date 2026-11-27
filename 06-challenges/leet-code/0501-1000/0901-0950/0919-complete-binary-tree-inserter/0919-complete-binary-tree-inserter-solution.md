# 919. Complete Binary Tree Inserter — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/complete-binary-tree-inserter/

---

## Solution: BFS Queue of Candidates — O(n) init, O(1) per insert

**Idea:** Maintain a deque of nodes that are not yet full (have missing children). The front is always the next parent to insert into.

**Algorithm:**
1. BFS to populate deque with nodes missing children.
2. `insert`: front of deque is parent; insert left or right; if parent now full, dequeue it; enqueue new node.

**Complexity:**

| | |
|---|---|
| Time | O(n) build, O(1) insert |
| Space | O(n) |
