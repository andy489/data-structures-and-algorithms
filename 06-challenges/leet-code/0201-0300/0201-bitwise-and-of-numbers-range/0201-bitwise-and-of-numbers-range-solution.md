# 201. Bitwise AND of Numbers Range — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/bitwise-and-of-numbers-range/

---

## Solution: Common Prefix (Bit Shift) — O(log n) time, O(1) space

**Idea:** Any bit that differs between `left` and `right` will flip to 0 at least once somewhere in the range `[left, right]`, making its AND contribution 0. Only the common binary prefix of `left` and `right` survives. Find it by right-shifting both until they are equal, then shift back left by the same count.

**Algorithm:**
1. Initialise `shift = 0`.
2. While `left != right`: right-shift both by 1, increment `shift`.
3. Return `left << shift`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — at most 32 iterations for 32-bit integers |
| Space | O(1) |

---

## Solution 2: Brian Kernighan Trick — O(log n) time, O(1) space

**Idea:** Repeatedly strip the lowest set bit of `right` until `right <= left`. The remaining value is the AND of the whole range.

**Algorithm:**
1. While `right > left`: clear the lowest set bit of `right` with `right &= (right - 1)`.
2. Return `right`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — number of set bits in `right`, at most 32 |
| Space | O(1) |
