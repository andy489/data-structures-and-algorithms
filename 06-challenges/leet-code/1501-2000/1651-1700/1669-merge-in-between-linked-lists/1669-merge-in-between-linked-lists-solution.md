# 1669. Merge In Between Linked Lists — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/merge-in-between-linked-lists/

---

## Solution: Two Pointer Traversal — O(n + m) time, O(1) space

**Idea:** Find the node just before index `a` (call it `preA`) and the node at index `b+1` (call it `postB`). Connect `preA.next = list2` head and `list2` tail to `postB`.

**Algorithm:**
1. Traverse `list1` to find `nodeBeforeA` (the node at index `a-1`).
2. Continue to find `nodeAfterB` (the node at index `b+1`).
3. Find the tail of `list2`.
4. Connect: `nodeBeforeA.next = list2`, `list2tail.next = nodeAfterB`.
5. Return `list1` head.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(1) |
