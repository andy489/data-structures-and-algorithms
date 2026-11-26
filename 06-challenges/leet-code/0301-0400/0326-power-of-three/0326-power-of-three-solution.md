# 326. Power of Three — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/power-of-three/

---

## Solution: Loop — O(log n) time, O(1) space

**Idea:** Repeatedly divide `n` by 3. If at any point `n % 3 != 0`, return false. If `n` reaches 1, return true.

**Algorithm:**
1. If `n <= 0`, return false.
2. While `n % 3 == 0`, divide `n` by 3.
3. Return `n == 1`.

**Complexity:**

| | |
|---|---|
| Time | O(log₃ n) |
| Space | O(1) |

---

## Solution 2: Math — O(1) time, O(1) space

**Idea:** The largest power of 3 fitting in a 32-bit integer is `3^19 = 1162261467`. If `n` is a power of 3, then `1162261467 % n == 0`.

**Algorithm:**
1. Return `n > 0 && 1162261467 % n == 0`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
