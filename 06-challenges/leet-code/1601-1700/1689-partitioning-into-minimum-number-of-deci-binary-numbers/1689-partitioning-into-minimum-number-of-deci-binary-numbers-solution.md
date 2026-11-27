# 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

---

## Solution: Max Digit — O(n) time, O(1) space

**Idea:** Each deci-binary number contributes at most 1 to any digit position. To satisfy digit `d` at some position, we need at least `d` deci-binary numbers. The bottleneck is the maximum digit in `n`.

**Algorithm:**
1. Find the maximum digit in the string `n`.
2. Return it as an integer.

**Complexity:**

| | |
|---|---|
| Time | O(n) where n = string length |
| Space | O(1) |
