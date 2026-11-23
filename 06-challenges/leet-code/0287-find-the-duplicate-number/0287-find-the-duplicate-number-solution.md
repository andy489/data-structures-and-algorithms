# 287. Find the Duplicate Number — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-duplicate-number/

---

## Solution: Floyd's Cycle Detection — O(n) time, O(1) space

**Idea:** Treat the array as a linked list where `nums[i]` is the next pointer from node `i`. Since there is a duplicate value `d`, two indices map to `d`, creating a cycle. Apply Floyd's slow/fast pointer algorithm to find the cycle entrance, which is the duplicate.

**Algorithm:**
1. Phase 1: Move slow by 1, fast by 2 until they meet inside the cycle.
2. Phase 2: Move one pointer from the meeting point and one from index 0, both by 1. They meet at the cycle entrance = duplicate.

**Complexity:**

| | |
|---|---|
| Time | O(n) — linear traversal |
| Space | O(1) — only two pointers |
