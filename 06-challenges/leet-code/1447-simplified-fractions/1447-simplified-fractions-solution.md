# 1447. Simplified Fractions — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/simplified-fractions/

---

## Solution: GCD Check — O(n^2 log n) time, O(1) space

**Idea:** For each denominator d from 2 to n, include numerator num if gcd(num, d) == 1.

**Algorithm:**
1. For d from 2 to n, for num from 1 to d-1: if gcd(num,d)==1, add 'num/d'.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 log n) |
| Space | O(1) |
