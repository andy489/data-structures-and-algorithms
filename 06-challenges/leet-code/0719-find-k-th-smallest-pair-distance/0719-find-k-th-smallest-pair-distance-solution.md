# 719. Find K-th Smallest Pair Distance — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-k-th-smallest-pair-distance/

---

## Solution: Binary Search + Sliding Window — O(n log n + n log W) time, O(1) space

**Idea:** Binary search on the answer (distance value d). Count how many pairs have distance ≤ d using a sliding window on the sorted array. Find the smallest d where count ≥ k.

**Algorithm:**
1. Sort `nums`. Set `lo = 0`, `hi = nums[n-1] - nums[0]`.
2. Binary search: `mid = (lo + hi) / 2`. Count pairs with distance ≤ mid using two-pointer on sorted array.
3. If count ≥ k, search left (hi = mid); else search right (lo = mid + 1).
4. Return `lo`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n + n log W) — W = max distance = 10^6 |
| Space | O(1) extra (excluding sort) |
