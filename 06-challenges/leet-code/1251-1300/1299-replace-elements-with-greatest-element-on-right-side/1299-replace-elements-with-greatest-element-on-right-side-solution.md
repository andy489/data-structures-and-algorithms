# 1299. Replace Elements with Greatest Element on Right Side — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

---

## Solution: Reverse Pass — O(n) time, O(1) space

**Idea:** Scan from right to left, tracking the running maximum.

**Algorithm:**
1. Start maxRight = -1.
2. Scan right to left: save arr[i], set arr[i] = maxRight, update maxRight = max(maxRight, saved).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
