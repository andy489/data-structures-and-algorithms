# 1287. Element Appearing More Than 25% In Sorted Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

---

## Solution: Quarter Candidates — O(n) time, O(1) space

**Idea:** In a sorted array, if an element appears more than 25% of the time, it must appear at indices i, i+n/4, i+n/2, or i+3n/4 for some i. Check candidates at those positions.

**Algorithm:**
1. Compute threshold = n/4.
2. Check arr[n/4], arr[n/2], arr[3n/4] as candidates.
3. For each, verify count > n/4 using binary search or linear count.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
