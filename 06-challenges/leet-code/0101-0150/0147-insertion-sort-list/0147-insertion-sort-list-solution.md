# 147. Insertion Sort List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/insertion-sort-list/

---

## Solution: Dummy Head + Linear Scan Insert — O(n²) time, O(1) space

**Idea:** Maintain a sorted sublist starting from a dummy head. For each node taken from the original list, scan the sorted sublist from the front to find the correct insertion position.

**Algorithm:**
1. Create a `dummy` sentinel node whose `next` points to the sorted portion.
2. Walk the original list with `curr`. For each `curr`:
   - If `curr.val >= prev.val` (already in order), advance `prev`.
   - Otherwise, reset `prev = dummy`, scan forward until `prev.next.val > curr.val`, then splice `curr` in after `prev`.
3. Return `dummy.next`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — each insertion may scan the whole sorted portion |
| Space | O(1) — pointer manipulation only |
