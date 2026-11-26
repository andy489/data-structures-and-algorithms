# 2040. Kth Smallest Product of Two Sorted Arrays — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/

---

## Solution: Binary Search on Answer — O((m+n) log(max_val^2)) time, O(1) space

**Idea:** Binary search on the product value. Count how many products <= mid.

**Algorithm:**
1. Binary search on value v in [-1e10, 1e10].
2. For each v, count pairs with product <= v.
3. For positive x in nums1, count nums2 <= v/x; for negative x, count nums2 >= ceil(v/x).
4. Return lo.

**Complexity:**

| | |
|---|---|
| Time | O((m+n) log(max_val^2)) |
| Space | O(1) |
