# 342. Power of Four — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/power-of-four/

---

## Solution: Bit Manipulation — O(1) time, O(1) space

**Idea:** A power of four must be a power of two (single set bit) AND that bit must be in an odd position (bit 0, 2, 4, ...). The mask `0x55555555` has 1s at all even positions.

**Algorithm:**
1. `n > 0 && (n & (n-1)) == 0 && (n & 0x55555555) != 0`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |

---

## Solution 2: Loop — O(log n) time, O(1) space

**Algorithm:**
1. If `n <= 0`, return false.
2. While `n % 4 == 0`, divide by 4.
3. Return `n == 1`.

**Complexity:**

| | |
|---|---|
| Time | O(log₄ n) |
| Space | O(1) |
