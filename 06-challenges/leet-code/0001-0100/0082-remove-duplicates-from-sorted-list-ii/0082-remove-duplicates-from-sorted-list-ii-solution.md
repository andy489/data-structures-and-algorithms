# 82. Remove Duplicates from Sorted List II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

---

## Solution: Sentinel + One Pass — O(n) time, O(1) space

**Idea:** Prepend a sentinel (dummy) node so we never need to special-case the head being removed. Walk with a `prev` pointer. Whenever `prev.next` and `prev.next.next` share the same value, record that value and advance `curr` past the entire run, then set `prev.next = curr` to excise the whole duplicate group. If no duplicate is detected, simply advance `prev`.

**Algorithm:**
1. Create `dummy.next = head`; set `prev = dummy`.
2. While `prev.next != null`:
   - If `prev.next.next != null && prev.next.val == prev.next.next.val`:
     - Record `val = prev.next.val`.
     - Advance `curr` while `curr != null && curr.val == val`.
     - Set `prev.next = curr` (skip all duplicates).
   - Else: `prev = prev.next`.
3. Return `dummy.next`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only pointer variables |
