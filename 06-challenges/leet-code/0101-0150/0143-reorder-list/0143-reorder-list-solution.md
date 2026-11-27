# 143. Reorder List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reorder-list/

---

## Solution 1: Find Middle + Reverse + Merge — O(n) time, O(1) space

**Idea:** Split the list at the midpoint, reverse the second half in-place, then interleave the two halves.

**Algorithm:**
1. Use slow/fast pointers to find the midpoint of the list.
2. Reverse the second half starting from `slow.next`.
3. Merge the two halves by alternating nodes: take one from the first half, then one from the reversed second half.

**Complexity:**

| | |
|---|---|
| Time | O(n) — three linear passes |
| Space | O(1) — in-place pointer manipulation |

---

## Solution 2: Deque — O(n) time, O(n) space

**Idea:** Collect all nodes into a deque, then repeatedly poll from the front and back to rebuild the list.

**Algorithm:**
1. Traverse the list and add each node to a `Deque<ListNode>`.
2. While the deque has more than one node: poll the front, attach it, then poll the back and attach it.
3. If one node remains, attach it last. Set the tail's `next` to `null`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — one traversal to build deque, one to rebuild |
| Space | O(n) — deque stores all n nodes |
