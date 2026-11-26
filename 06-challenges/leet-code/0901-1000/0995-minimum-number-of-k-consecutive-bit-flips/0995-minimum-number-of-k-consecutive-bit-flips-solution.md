# 995. Minimum Number of K Consecutive Bit Flips — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/

---

## Solution: Sliding Window with Flip Count — O(n) time, O(n) space

**Idea:** Use a difference array to track how many flips are "active" at each position without actually flipping.

**Algorithm:**
1. `flip[]` marks where flips start. `flipped` = parity of active flips.
2. If current bit XOR flipped == 0, we need a flip here. If not enough room, return -1.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — flip array |
