# 206. Reverse Linked List — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/reverse-linked-list/

---

## Solution: Iterative — O(n) time, O(1) space

**Idea:** Walk the list, re-wiring each node's `next` pointer to the previous node.

**Algorithm:**
1. Initialise `prev = null`, `curr = head`.
2. While `curr != null`:
   - Save `next = curr.next`.
   - Set `curr.next = prev`.
   - Advance `prev = curr`, `curr = next`.
3. Return `prev` (new head).

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — three pointers |

---

## Solution 2: Recursive — O(n) time, O(n) space

**Idea:** Recurse to the tail, then re-wire on the way back up.

**Algorithm:**
1. Base case: if `head == null` or `head.next == null`, return `head`.
2. `newHead = reverse(head.next)`.
3. `head.next.next = head`; `head.next = null`.
4. Return `newHead`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — call stack depth |
