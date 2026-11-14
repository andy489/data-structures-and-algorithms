# 92. Reverse Linked List II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reverse-linked-list-ii/

---

## Solution: One-Pass In-Place Reversal — O(n) time, O(1) space

**Idea:** Use a sentinel dummy node before the head so `left = 1` needs no special case. Walk to the node just before position `left` (`prev`). Then reverse the sublist of length `right - left + 1` one node at a time by repeatedly pulling the next node of `curr` to the front of the reversed segment (front-insertion / "head-insertion" technique).

**Algorithm:**
1. Create `dummy -> head`; set `prev = dummy`.
2. Advance `prev` exactly `left - 1` steps so it points just before the segment.
3. Set `curr = prev.next` (first node of the segment).
4. Repeat `right - left` times:
   - `next = curr.next`
   - `curr.next = next.next`
   - `next.next = prev.next`
   - `prev.next = next`
5. Return `dummy.next`.

**Why it works:** Each iteration takes `next` (the node immediately after `curr`) and inserts it right after `prev`, effectively prepending it to the already-reversed prefix of the segment. `curr` stays fixed as the "tail" of the growing reversed segment.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass; at most n steps total |
| Space | O(1) — only a constant number of pointers |

---

## Solution 2: Recursion — O(n) time, O(n) space

**Idea:** When `left == 1` we need to reverse the first `right` nodes: reverse a prefix of length `right`, return the new head, and reattach the original head (now the tail) to the remainder. For `left > 1` we skip the first node and recurse on the rest with `left - 1` and `right - 1`, then prepend the skipped node.

**Algorithm:**
1. Base case: if `right == 1`, no reversal needed — set `tail = head.next` and return `head`.
2. If `left == 1`:
   - Save `successor = head.next` before the recursive call.
   - Recurse: `newHead = reverseBetween(successor, 1, right - 1)`.
   - Wire: `successor.next = head`, `head.next = tail`, `tail = head`.
   - Return `newHead`.
3. If `left > 1`:
   - Recurse: `head.next = reverseBetween(head.next, left - 1, right - 1)`.
   - Return `head`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — linear recursion depth |
| Space | O(n) — call stack depth proportional to `right` |
