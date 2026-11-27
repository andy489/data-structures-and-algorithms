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

**Idea:** Decompose into two recursive helpers. `reverseN(head, n)` reverses the first `n` nodes of a list and stores the node after the reversed segment in `successor`, so the new tail can be attached to it. `reverseBetween(head, left, right)` skips nodes until `left == 1`, then delegates to `reverseN(head, right)`.

**Algorithm (`reverseN`):**
1. Base case: `n == 1` → save `successor = head.next`, return `head`.
2. Recurse: `newHead = reverseN(head.next, n - 1)`.
3. Wire: `head.next.next = head` (point the current tail back to `head`), `head.next = successor` (attach `head` to the rest of the list).
4. Return `newHead`.

**Algorithm (`reverseBetween`):**
1. If `left == 1`: call `reverseN(head, right)` and return its result.
2. Otherwise: recurse `head.next = reverseBetween(head.next, left - 1, right - 1)` and return `head`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — linear recursion depth |
| Space | O(n) — call stack depth proportional to `right` |
