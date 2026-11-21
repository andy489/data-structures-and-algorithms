# 191. Number of 1 Bits — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-1-bits/

---

## Solution: Brian Kernighan's Algorithm — O(k) time, O(1) space

**Idea:** `n & (n-1)` clears the lowest set bit. Repeat until `n == 0`, counting iterations.

**Complexity:**

| | |
|---|---|
| Time | O(k) where k = number of set bits ≤ 32 |
| Space | O(1) |
