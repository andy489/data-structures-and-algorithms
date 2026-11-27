# 795. Number of Subarrays with Bounded Maximum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

---

## Solution: Two-Pass Count — O(n) time, O(1) space

**Idea:** `count(nums, bound)` counts subarrays with max ≤ bound. Answer = count(right) - count(left-1).

**Algorithm:**
1. For `count(bound)`: track length of current valid window; reset when nums[i] > bound; add window length each step.
2. Result = count(right) - count(left - 1).

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear scans |
| Space | O(1) |
