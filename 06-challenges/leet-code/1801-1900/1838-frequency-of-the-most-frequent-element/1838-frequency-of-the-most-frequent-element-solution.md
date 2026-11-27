# 1838. Frequency of the Most Frequent Element — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/frequency-of-the-most-frequent-element/

---

## Solution: Sort + Sliding Window — O(n log n) time, O(1) space

**Idea:** Sort the array. For a window `[l, r]`, the target value is `nums[r]` (all elements are raised to match the rightmost, largest value). The cost to make all elements in the window equal `nums[r]` is `nums[r] * windowSize - windowSum`. Expand the window to the right; when cost exceeds `k`, shrink from the left.

**Algorithm:**
1. Sort `nums`.
2. Use two pointers `l = 0`, sliding `r` from 0 to n-1.
3. Maintain `windowSum`. Cost = `nums[r] * (r - l + 1) - windowSum`.
4. While `cost > k`: subtract `nums[l]` from `windowSum`, increment `l`.
5. Track `max(r - l + 1)` as the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting dominates |
| Space | O(1) — sort in-place, O(log n) stack for sort |
