# 932. Beautiful Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/beautiful-array/

---

## Solution: Divide and Conquer — O(n log n) time, O(n log n) space

**Idea:** A beautiful array can be split: all odds on left, all evens on right. If odd+odd=even, the middle element (even) cannot satisfy the condition; and cross-pairs (odd+even=odd≠even). Recursively build for ceil(n/2) and floor(n/2), then map: odds = 2*x-1, evens = 2*x.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n log n) |
