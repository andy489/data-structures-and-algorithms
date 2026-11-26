# 1525. Number of Good Ways to Split a String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

---

## Solution: Prefix/Suffix Distinct Count — O(n) time, O(1) space

**Idea:** Maintain frequency arrays for the left and right parts. As we scan left to right, we add the current character to the left side and remove it from the right side, tracking distinct character counts for each.

**Algorithm:**
1. Precompute frequency of all characters in the right part (whole string).
2. Count initial distinct count for right.
3. Iterate through each character: add to left frequency (increment leftDistinct if new), remove from right frequency (decrement rightDistinct if depleted).
4. If leftDistinct equals rightDistinct, increment result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass after initialization |
| Space | O(1) — fixed-size arrays of 26 |
