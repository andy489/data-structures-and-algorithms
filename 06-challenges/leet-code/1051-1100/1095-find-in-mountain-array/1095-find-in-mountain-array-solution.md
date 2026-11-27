# 1095. Find in Mountain Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-in-mountain-array/

---

## Solution: Triple Binary Search — O(log n) time, O(1) space

**Idea:** 1. Find peak index. 2. Binary search ascending side. 3. If not found, binary search descending side.

**Algorithm:**
1. Binary search for peak: find index where arr[mid] > arr[mid+1].
2. Binary search left half for target (ascending).
3. Binary search right half for target (descending).

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
