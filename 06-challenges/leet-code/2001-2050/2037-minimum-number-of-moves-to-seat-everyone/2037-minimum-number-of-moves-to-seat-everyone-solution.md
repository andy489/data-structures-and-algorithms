# 2037. Minimum Number of Moves to Seat Everyone — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/

---

## Solution: Sort Both Arrays — O(n log n) time, O(1) space

**Idea:** Sort both arrays. Match i-th seat with i-th student, sum absolute differences.

**Algorithm:**
1. Sort `seats` and `students`.
2. Return `sum(|seats[i] - students[i]|)`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
