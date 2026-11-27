# 142. Linked List Cycle II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/linked-list-cycle-ii/

---

## Solution 1: HashSet — O(n) time, O(n) space

**Idea:** Walk the list and record each visited node in a set. The first node seen twice is the cycle entry. If the traversal reaches `null`, there is no cycle.

**Algorithm:**
1. Traverse the list; for each node, check if it is already in the set.
2. If yes, return that node. Otherwise, add it to the set and continue.
3. Return `null` if the loop ends.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — each node visited once |
| Space | O(n) — set stores up to n nodes |

---

## Solution 2: Floyd's Cycle Detection — O(n) time, O(1) space

**Idea:** Use slow/fast pointers to detect a cycle (meeting point inside the cycle), then reset one pointer to `head`. Advancing both one step at a time, they meet exactly at the cycle entry.

**Why it works:** Let `F` = distance from head to cycle entry, `C` = cycle length, `a` = distance from entry to meeting point. At the meeting: slow has traveled `F + a`, fast has traveled `F + a + C` (one extra loop). Since fast moves twice as fast: `2(F + a) = F + a + C` → `F = C - a`. So starting fresh from head and from meeting point, both reach the entry simultaneously.

**Algorithm:**
1. Find meeting point with slow/fast pointers (or return `null` if no cycle).
2. Reset `slow = head`. Advance both one step at a time.
3. Return the node where they meet.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — at most two passes |
| Space | O(1) — two pointers |
