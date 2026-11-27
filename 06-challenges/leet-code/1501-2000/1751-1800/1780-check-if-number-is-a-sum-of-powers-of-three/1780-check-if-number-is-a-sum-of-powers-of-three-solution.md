# 1780. Check if Number is a Sum of Powers of Three — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

---

## Solution: Base-3 Representation — O(log n) time, O(1) space

**Idea:** A number can be expressed as a sum of distinct powers of three if and only if its base-3 representation contains only digits 0 and 1 (no digit 2). If a base-3 digit is 2, it means we need to use the same power of three twice, which violates the "distinct" constraint.

**Algorithm:**
1. Repeatedly divide `n` by 3.
2. At each step, check if the remainder is 2.
3. If the remainder is ever 2, return `false`.
4. If we exhaust all digits (n becomes 0), return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — number of digits in base-3 representation |
| Space | O(1) — constant extra space |
