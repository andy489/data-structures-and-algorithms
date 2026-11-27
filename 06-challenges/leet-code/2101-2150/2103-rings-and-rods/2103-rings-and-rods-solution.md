# 2103. Rings and Rods — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/rings-and-rods/

---

## Solution: Bitmask per Rod — O(n) time, O(1) space

**Idea:** Use a bitmask of 3 bits for each of the 10 rods to track which colors are present. Bit 0 = Red, Bit 1 = Green, Bit 2 = Blue. After processing all rings, count rods whose bitmask equals `0b111 = 7` (all three colors present).

**Algorithm:**
1. Initialize `mask[10] = {0}`.
2. For each pair `(color, rod)` in the input string:
   - If color is `'R'`, set bit 0: `mask[rod] |= 1`.
   - If color is `'G'`, set bit 1: `mask[rod] |= 2`.
   - If color is `'B'`, set bit 2: `mask[rod] |= 4`.
3. Count rods where `mask[rod] == 7`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the string |
| Space | O(1) — fixed array of 10 integers |
