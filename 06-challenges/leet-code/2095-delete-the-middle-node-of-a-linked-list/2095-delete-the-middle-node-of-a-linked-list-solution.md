# 2095. Delete the Middle Node of a Linked List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

---

## Solution: Slow and Fast Pointers — O(n) time, O(1) space

**Idea:** Use two-pointer technique: slow moves 1, fast moves 2. When fast reaches end, slow is at middle. Delete slow.next or use a trail pointer.

**Algorithm:**
1. Count nodes OR use slow/fast.
2. Fast moves 2 steps, slow 1 step (slow starts 1 behind for clean deletion).
3. Delete slow.next when fast reaches end.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
