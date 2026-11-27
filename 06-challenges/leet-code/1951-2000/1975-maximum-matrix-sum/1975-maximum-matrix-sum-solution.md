# 1975. Maximum Matrix Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-matrix-sum/

---

## Solution: Greedy — O(n²) time, O(1) space

**Idea:** We can always move a negative sign to any position by flipping adjacent pairs. If there is an even number of negatives, we can make all elements positive. If odd, we must leave one negative — so we negate the element with the smallest absolute value.

**Algorithm:**
1. Count negatives and find the minimum absolute value.
2. Sum all absolute values.
3. If count of negatives is even, return sum; else return `sum - 2 * minAbs`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(1) |
