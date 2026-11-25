# 912. Sort an Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sort-an-array/

---

## Solution: Merge Sort — O(n log n) time, O(n) space

**Idea:** Classic divide-and-conquer merge sort.

**Algorithm:**
1. Recursively split array into halves.
2. Merge sorted halves using auxiliary array.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) — merge buffer |
