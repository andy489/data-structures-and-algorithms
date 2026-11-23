# 410. Split Array Largest Sum — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/split-array-largest-sum/

---

## Solution: Binary Search on Answer — O(n·log(sum)) time, O(1) space

**Idea:** Binary search on the answer (the maximum subarray sum). For a given candidate `mid`, greedily check if we can split `nums` into at most `k` subarrays where each has sum ≤ `mid`. The search space is `[max(nums), sum(nums)]`.

**Algorithm:**
1. Set `lo = max(nums)`, `hi = sum(nums)`.
2. While `lo < hi`: `mid = (lo + hi) / 2`. Check if `mid` is feasible.
3. Feasibility: greedily accumulate; whenever adding next element exceeds `mid`, start a new subarray. Count splits needed.
4. If splits ≤ k, `hi = mid`; else `lo = mid + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n·log(sum)) — binary search with O(n) feasibility check |
| Space | O(1) |
