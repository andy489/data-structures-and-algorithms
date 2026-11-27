# 3065. Minimum Operations To Exceed Threshold Value I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/

---

## Solution: Count — O(n) time, O(1) space

**Idea:** Count elements strictly less than k — each requires one removal operation.

**Algorithm:**
1. Count elements where nums[i] < k.
2. Return that count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) |
| Space | O(1) — O(1) |
