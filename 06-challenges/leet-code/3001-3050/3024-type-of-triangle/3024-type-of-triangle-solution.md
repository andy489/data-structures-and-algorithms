# 3024. Type Of Triangle — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/type-of-triangle/

---

## Solution: Case Analysis — O(1) time, O(1) space

**Idea:** First validate the triangle inequality, then classify by side equality.

**Algorithm:**
1. Sort the array.
2. Check triangle inequality: a+b > c (after sorting).
3. Count distinct values.
4. Return equilateral/isosceles/scalene/none accordingly.

**Complexity:**

| | |
|---|---|
| Time | O(1) — O(1) — fixed size 3 |
| Space | O(1) — O(1) |
