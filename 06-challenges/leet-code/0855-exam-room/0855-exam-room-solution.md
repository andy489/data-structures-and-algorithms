# 855. Exam Room — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/exam-room/

---

## Solution: Sorted Set — O(n) seat, O(log n) leave

**Idea:** Maintain a sorted list of occupied seats. For `seat()`, consider: sitting at 0, at n-1, and in the middle of each gap. Pick the seat that maximizes min-distance.

**Algorithm:**
1. Keep sorted list of occupied seats.
2. `seat()`: evaluate distance for seat 0, seat n-1, and midpoints of consecutive gaps. Pick the best (ties broken by lowest index). Insert and return.
3. `leave(p)`: remove p from the sorted list.

**Complexity:**

| | |
|---|---|
| Time | O(n) seat, O(n) leave — scanning sorted list |
| Space | O(n) — stored seats |
