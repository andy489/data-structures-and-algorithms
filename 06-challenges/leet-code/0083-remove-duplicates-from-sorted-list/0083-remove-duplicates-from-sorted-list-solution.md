# 83. Remove Duplicates from Sorted List — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/remove-duplicates-from-sorted-list/

---

## Solution: One Pass — O(n) time, O(1) space

**Idea:** Walk `curr` through the list. Whenever `curr.next` has the same value as `curr`, skip `curr.next` by setting `curr.next = curr.next.next`. Otherwise advance `curr`. Because the list is sorted, all duplicates of a value are consecutive, so a single pass is sufficient.

**Algorithm:**
1. Set `curr = head`.
2. While `curr != null && curr.next != null`:
   - If `curr.val == curr.next.val`: `curr.next = curr.next.next`.
   - Else: `curr = curr.next`.
3. Return `head`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — in-place pointer updates |
