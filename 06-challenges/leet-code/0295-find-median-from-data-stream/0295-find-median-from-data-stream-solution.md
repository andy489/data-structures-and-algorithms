# 295. Find Median from Data Stream — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-median-from-data-stream/

---

## Solution: Two Heaps (Max-heap + Min-heap) — O(log n) add, O(1) findMedian

**Idea:** Maintain two heaps:
- `lo`: a max-heap storing the smaller half.
- `hi`: a min-heap storing the larger half.

Invariant: `|lo.size() - hi.size()| <= 1`, and `lo.peek() <= hi.peek()`.

**Algorithm:**
1. `addNum(num)`:
   - Add `num` to `lo` (max-heap).
   - Move `lo.peek()` to `hi` (keeps max of small half ≤ min of large half).
   - If `hi.size() > lo.size()`, move `hi.peek()` back to `lo`.
2. `findMedian()`:
   - If sizes equal: `(lo.peek() + hi.peek()) / 2.0`.
   - Otherwise: `lo.peek()`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — heap operations for addNum; O(1) for findMedian |
| Space | O(n) — stores all elements |
