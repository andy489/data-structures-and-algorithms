# 1200. Minimum Absolute Difference — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-absolute-difference/

---

## Solution: Sort — O(n log n) time, O(1) space

**Idea:** Sort the array. Minimum absolute difference is between adjacent elements. Find that min, then collect all adjacent pairs with that difference.

**Algorithm:**
1. Sort arr.
2. Find minimum consecutive difference.
3. Collect all adjacent pairs with that difference.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
