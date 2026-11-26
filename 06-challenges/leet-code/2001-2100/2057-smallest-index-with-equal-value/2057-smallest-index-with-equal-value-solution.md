# 2057. Smallest Index With Equal Value — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/smallest-index-with-equal-value/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Scan and return the first index where i % 10 == nums[i].

**Algorithm:**
1. For each index `i`, check `i % 10 == nums[i]`.
2. Return first match or -1.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
