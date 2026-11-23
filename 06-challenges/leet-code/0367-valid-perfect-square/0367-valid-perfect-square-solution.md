# 367. Valid Perfect Square — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-perfect-square/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** Binary search for an integer `x` in `[1, num]` such that `x * x == num`.

**Algorithm:**
1. Binary search `lo = 1, hi = num`.
2. At each `mid`, if `mid * mid == num` return true; if `mid * mid < num` go right; else go left.
3. Return false if not found.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
