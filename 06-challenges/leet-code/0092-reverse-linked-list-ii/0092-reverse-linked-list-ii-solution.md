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
