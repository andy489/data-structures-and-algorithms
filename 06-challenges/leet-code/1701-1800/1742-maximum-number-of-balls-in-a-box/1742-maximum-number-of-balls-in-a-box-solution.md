# 1742. Maximum Number of Balls in a Box — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-number-of-balls-in-a-box/

---

## Solution: Digit-Sum Frequency Count — O(n · d) time, O(1) space

**Idea:** For each ball number compute its digit sum and increment a frequency counter. The maximum digit sum for 100000 is 1+0+0+0+0+0 = 1 ... actually max is 99999 → 9+9+9+9+9 = 45. So the counter array has at most 46 entries.

**Algorithm:**
1. Allocate a count array of size 46 (max possible digit sum).
2. For each number from `lowLimit` to `highLimit`, compute digit sum and increment count.
3. Return the maximum count.

**Complexity:**

| | |
|---|---|
| Time | O(n · d) — n numbers, each with at most d=5 digits |
| Space | O(1) — fixed-size counter array (46 entries) |
