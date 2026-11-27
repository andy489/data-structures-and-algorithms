# 908. Smallest Range I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/smallest-range-i/

---

## Solution: Math — O(n) time, O(1) space

**Idea:** Raise min by k, lower max by k. The gap shrinks by 2k. If 2k ≥ gap, answer is 0.

**Algorithm:**
1. Find max and min of nums.
2. Return max(0, max - min - 2k).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
