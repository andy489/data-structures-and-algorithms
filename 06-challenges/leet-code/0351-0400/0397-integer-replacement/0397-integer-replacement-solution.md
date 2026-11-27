# 397. Integer Replacement — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/integer-replacement/

---

## Solution: Greedy / Bit Manipulation — O(log n) time, O(1) space

**Idea:** When n is even, divide by 2. When odd, choose +1 or -1 to make the last two bits `00` as quickly as possible. Special case: `n = 3` → subtract 1 (3 → 2 → 1 = 2 steps vs 3 → 4 → 2 → 1 = 3 steps).

**Rule:**
- If odd and last two bits are `11` (i.e., `(n & 3) == 3` and `n != 3`): add 1.
- Otherwise: subtract 1.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
