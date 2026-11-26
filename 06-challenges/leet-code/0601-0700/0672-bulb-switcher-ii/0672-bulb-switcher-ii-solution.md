# 672. Bulb Switcher II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bulb-switcher-ii/

---

## Solution: Math/Observation — O(1) time, O(1) space

**Idea:** Only the first 6 bulbs matter (LCM of 1,2,3,6). After analysis of all button combinations, the answer only depends on `n` and `presses` with small case analysis.

**Algorithm:**
- If `presses == 0`: return 1.
- If `n == 1`: return 2.
- If `n == 2`: return `presses == 1 ? 3 : 4`.
- If `presses == 1`: return 4.
- If `presses == 2`: return 7.
- Else: return 8.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
