# 328. Odd Even Linked List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/odd-even-linked-list/

---

## Solution: Two Pointers (In-Place) — O(n) time, O(1) space

**Idea:** Maintain two pointers: one for the tail of odd nodes, one for the tail of even nodes. Weave through the list connecting odd nodes together and even nodes together, then attach even head after odd tail.

**Algorithm:**
1. `odd = head`, `even = head.next`, `evenHead = even`.
2. While `even != null && even.next != null`:
   - `odd.next = even.next` (skip even)
   - `odd = odd.next`
   - `even.next = odd.next` (skip odd)
   - `even = even.next`
3. `odd.next = evenHead`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
