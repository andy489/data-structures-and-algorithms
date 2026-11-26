# 1460. Make Two Arrays Equal By Reversing Subarrays — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/

---

## Solution: Sort and Compare — O(n log n) time, O(n) space

**Idea:** Reversing subarrays can achieve any permutation. So arr can equal target iff they have same elements.

**Algorithm:**
1. Sort both arrays. Return if they're equal.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
