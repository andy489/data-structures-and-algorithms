# 1276. Number of Burgers with No Waste of Ingredients — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/

---

## Solution: Linear Equations — O(1) time, O(1) space

**Idea:** Let j=jumbo, s=small. 4j+2s=tomatoSlices, j+s=cheeseSlices. Solving: j=(t-2c)/2, s=c-j.

**Algorithm:**
1. j = (tomatoSlices - 2*cheeseSlices) / 2
2. s = cheeseSlices - j
3. Return [] if j<0, s<0, or j is not integer.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
