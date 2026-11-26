# 2048. Next Greater Numerically Balanced Number — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/next-greater-numerically-balanced-number/

---

## Solution: Brute Force Check — O(n * digits) time, O(1) space

**Idea:** Increment from n+1 and check each candidate for balance property.

**Algorithm:**
1. For each candidate c = n+1, n+2,...: count digit frequencies, check if each digit d appears exactly d times.

**Complexity:**

| | |
|---|---|
| Time | O(n * digits) |
| Space | O(1) |
