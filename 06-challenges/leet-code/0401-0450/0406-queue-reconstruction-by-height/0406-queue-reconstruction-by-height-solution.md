# 406. Queue Reconstruction by Height — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/queue-reconstruction-by-height/

---

## Solution: Sort then Insert — O(n²) time, O(n) space

**Idea:** Sort people by height descending (taller first), breaking ties by k ascending. Then insert each person at index k into a result list. Because we insert taller people first, inserting at position k gives exactly k people of equal or greater height already placed.

**Algorithm:**
1. Sort: descending by height, ascending by k for ties.
2. Create an empty result list.
3. For each person, insert at index `person[1]` (their k value).
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — each insertion into list is O(n) |
| Space | O(n) — result list |
