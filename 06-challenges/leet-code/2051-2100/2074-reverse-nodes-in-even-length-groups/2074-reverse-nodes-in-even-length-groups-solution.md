# 2074. Reverse Nodes in Even-Length Groups — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reverse-nodes-in-even-length-groups/

---

## Solution: Linked List Manipulation — O(n) time, O(1) space

**Idea:** Traverse list, track group size. If group has even length, reverse it in-place.

**Algorithm:**
1. Traverse groups in order.
2. For each group, check actual length (may be less than group number for last group).
3. If even length, reverse that group's sublist.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
