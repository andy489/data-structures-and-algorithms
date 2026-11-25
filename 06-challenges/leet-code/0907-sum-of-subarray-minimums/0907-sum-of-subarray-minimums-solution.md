# 907. Sum of Subarray Minimums — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-subarray-minimums/

---

## Solution: Monotonic Stack — O(n) time, O(n) space

**Idea:** For each element `arr[i]`, count how many subarrays have `arr[i]` as minimum. Use previous-less and next-less-or-equal arrays computed with monotonic stack. Contribution = arr[i] * left[i] * right[i].

**Algorithm:**
1. Compute `left[i]` = distance to previous strictly smaller element (or i+1 if none).
2. Compute `right[i]` = distance to next smaller-or-equal element (or n-i if none).
3. Answer = sum of arr[i] * left[i] * right[i], mod 1e9+7.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
