# 21. Merge Two Sorted Lists — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/merge-two-sorted-lists/

---

## Solution: Iterative (Dummy Head) — O(n + m) time, O(1) space

**Idea:** Use a dummy sentinel node as the head of the result list. Advance a `curr` pointer, always attaching the smaller of the two front nodes. Once one list is exhausted, attach the remaining tail of the other.

**Algorithm:**
1. Create a dummy node; set `curr = dummy`.
2. While both `list1` and `list2` are non-null:
   - If `list1.val <= list2.val`, attach `list1` and advance `list1`.
   - Otherwise, attach `list2` and advance `list2`.
   - Advance `curr`.
3. Attach whichever list still has remaining nodes.
4. Return `dummy.next`.

**Complexity:**

| | |
|---|---|
| Time  | O(n + m) — each node is visited exactly once |
| Space | O(1) — only pointers, no extra allocation |

---

## Solution 2: Recursive — O(n + m) time, O(n + m) space

**Idea:** At each call, pick the node with the smaller value and recursively merge the rest.

**Algorithm:**
1. Base cases: if either list is null, return the other.
2. If `list1.val <= list2.val`, set `list1.next = merge(list1.next, list2)` and return `list1`.
3. Otherwise, set `list2.next = merge(list1, list2.next)` and return `list2`.

**Complexity:**

| | |
|---|---|
| Time  | O(n + m) — each node produces one recursive call |
| Space | O(n + m) — call stack depth equals total node count |
