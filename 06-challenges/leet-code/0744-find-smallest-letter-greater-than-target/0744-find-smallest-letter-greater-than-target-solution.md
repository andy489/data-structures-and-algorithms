# 744. Find Smallest Letter Greater Than Target — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-smallest-letter-greater-than-target/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** Binary search for the leftmost position where `letters[mid] > target`. Wrap around with modulo.

**Algorithm:**
1. Binary search: find leftmost index where `letters[idx] > target`.
2. Return `letters[idx % n]` (wraps to first if no greater element).

**Complexity:**

| | |
|---|---|
| Time | O(log n) — binary search |
| Space | O(1) |
