# 503. Next Greater Element II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/next-greater-element-ii/

---

## Solution: Monotonic Stack (Two Passes) — O(n) time, O(n) space

**Idea:** Simulate circularity by iterating 2n indices (mod n). Use a monotonic decreasing stack of indices. When we find a greater element, resolve all waiting indices on the stack.

**Algorithm:**
1. Initialize result array with -1, stack empty.
2. Iterate i from 0 to 2n-1; use `nums[i % n]`.
3. While stack non-empty and `nums[i % n] > nums[stack.top()]`, pop and assign result.
4. Push `i % n` only during first pass (i < n).

**Complexity:**

| | |
|---|---|
| Time | O(n) — each index pushed/popped once |
| Space | O(n) — stack |
