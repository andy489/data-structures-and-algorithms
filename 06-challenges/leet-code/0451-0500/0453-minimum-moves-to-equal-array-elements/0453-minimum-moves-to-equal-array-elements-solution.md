# 453. Minimum Moves to Equal Array Elements — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

---

## Solution: Math — O(n) time, O(1) space

**Idea:** Incrementing n-1 elements by 1 is equivalent to decrementing 1 element by 1. So we want to minimize the total decrements to bring all elements to the minimum. The answer is `sum - n * min`.

**Algorithm:**
1. Find `minVal = min(nums)`.
2. Return `sum(nums) - n * minVal`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
