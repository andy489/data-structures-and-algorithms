# 1845. Seat Reservation Manager — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/seat-reservation-manager/

---

## Solution: Min-Heap — O(n + q log n) time, O(n) space

**Idea:** Pre-load all seats 1..n into a min-heap. `reserve()` polls the minimum; `unreserve(x)` pushes `x` back. The heap invariant always gives us the smallest available seat in O(log n).

**Algorithm:**
1. Constructor: push 1..n into a min-heap.
2. `reserve()`: poll and return the heap minimum.
3. `unreserve(seatNumber)`: push `seatNumber` back into the heap.

**Complexity:**

| | |
|---|---|
| Time | O(n) build + O(log n) per call |
| Space | O(n) — heap storage |
