# 658. Find K Closest Elements — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-k-closest-elements/

---

## Solution: Binary Search on Window Start — O(log(n-k) + k) time, O(1) space

**Idea:** Binary search for the left boundary of the k-element window. We compare `x - arr[mid]` vs `arr[mid+k] - x` to decide whether to move right.

**Algorithm:**
1. Binary search `lo=0, hi=n-k`.
2. At `mid`: if `x - arr[mid] > arr[mid+k] - x`, move `lo = mid+1`; else `hi = mid`.
3. Result is `arr[lo..lo+k-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(log(n-k) + k) |
| Space | O(1) |
