# 400. Nth Digit — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/nth-digit/

---

## Solution: Math — O(log n) time, O(1) space

**Idea:** Numbers are grouped by digit count:
- 1-digit: 1–9 (9 numbers, 9 digits)
- 2-digit: 10–99 (90 numbers, 180 digits)
- d-digit: 10^(d-1)..10^d - 1 (9·10^(d-1) numbers, d·9·10^(d-1) digits)

**Algorithm:**
1. Find the digit group d by subtracting counts from n.
2. Find the actual number within the group.
3. Find the specific digit within that number.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — iterating over digit lengths |
| Space | O(1) |
