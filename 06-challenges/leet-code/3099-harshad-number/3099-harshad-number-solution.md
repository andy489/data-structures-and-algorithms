# 3099. Harshad Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/harshad-number/

---

## Solution: Digit Sum — O(D) time, O(1) space

**Idea:** Compute digit sum, check divisibility, return accordingly.

**Algorithm:**
1. Compute digitSum = sum of digits of x.
2. If x % digitSum == 0: return digitSum.
3. Else return -1.

**Complexity:**

| | |
|---|---|
| Time | O(D) — O(D) where D = digits of x |
| Space | O(1) — O(1) |
