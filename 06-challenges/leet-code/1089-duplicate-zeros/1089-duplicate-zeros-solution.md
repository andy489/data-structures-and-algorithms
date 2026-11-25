# 1089. Duplicate Zeros — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/duplicate-zeros/

---

## Solution: Two-Pass In-Place — O(n) time, O(1) space

**Idea:** First count zeros to know the final length. Then work backwards from the last valid element to place it in its shifted position.

**Algorithm:**
1. Count zeros in arr, compute tail position.
2. Iterate backwards from the tail, placing each element (zero placed twice).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
