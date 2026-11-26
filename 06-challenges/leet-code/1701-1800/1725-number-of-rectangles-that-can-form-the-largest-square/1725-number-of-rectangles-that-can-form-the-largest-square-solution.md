# 1725. Number of Rectangles That Can Form The Largest Square — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Each rectangle can produce a square of side `min(l, w)`. Find the global maximum of these values, then count how many rectangles achieve it.

**Algorithm:**
1. Scan rectangles; track `maxLen = max(min(l, w))` and count how many rectangles equal `maxLen`, resetting the count when a new maximum is found.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra |
