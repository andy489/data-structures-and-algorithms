# 852. Peak Index in a Mountain Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/peak-index-in-a-mountain-array/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** Use binary search. If `arr[mid] < arr[mid+1]`, the peak is to the right; otherwise it's at mid or to the left.

**Algorithm:**
1. Set lo = 0, hi = n - 1.
2. While lo < hi: mid = (lo + hi) / 2. If arr[mid] < arr[mid+1], lo = mid+1. Else hi = mid.
3. Return lo.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
