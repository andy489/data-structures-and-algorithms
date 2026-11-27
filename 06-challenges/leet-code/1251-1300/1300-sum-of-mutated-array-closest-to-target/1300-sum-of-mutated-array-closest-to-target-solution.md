# 1300. Sum of Mutated Array Closest to Target — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/

---

## Solution: Binary Search — O(n log n) time, O(1) space

**Idea:** Binary search on value in [0, max(arr)]. For a given value v, sum = sum of min(arr[i], v). Find v minimizing |sum - target|.

**Algorithm:**
1. Sort arr; binary search on v.
2. For each v, compute sum using prefix sums (or direct).
3. Track closest sum to target.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
