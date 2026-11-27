# 2009. Minimum Number of Operations to Make Array Continuous — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/

---

## Solution: Sort + Sliding Window — O(n log n) time, O(n) space

**Idea:** Sort and deduplicate. For each possible window [x, x+n-1], count how many existing unique elements fall in; the rest need replacement.

**Algorithm:**
1. Deduplicate and sort.
2. Use two pointers to find max elements in window [nums[i], nums[i]+n-1].
3. Answer = n - max elements in any such window.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
