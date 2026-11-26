# 1464. Maximum Product Of Two Elements In An Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

---

## Solution: Find Two Largest — O(n) time, O(1) space

**Idea:** Find the two largest values. Answer = (max1-1)*(max2-1).

**Algorithm:**
1. Track top two maximums in one pass.
2. Return (max1-1)*(max2-1).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
