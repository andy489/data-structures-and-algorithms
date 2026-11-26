# 1705. Maximum Number of Eaten Apples — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-eaten-apples/

---

## Solution: Greedy with Min-Heap — O(n log n) time, O(n) space

**Idea:** Greedily eat the apple that expires soonest each day (greedy: eat what expires first). Use a min-heap keyed by expiry date. Each day, add new apples (if any), remove expired apples, and eat one from the soonest-expiring batch.

**Algorithm:**
1. Use a min-heap of `[expiryDay, count]` pairs.
2. For each day from 0 to n-1 (and beyond while heap non-empty):
   - Add `[i + days[i], apples[i]]` to heap if `apples[i] > 0`.
   - Poll expired batches (expiryDay <= i).
   - If heap non-empty, eat one apple from the top batch.
3. Continue after day n until heap is empty.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — heap operations |
| Space | O(n) — heap size |
