# 816. Ambiguous Coordinates — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/ambiguous-coordinates/

---

## Solution: Enumeration — O(n³) time, O(n³) space

**Idea:** Split the digits into two parts (for x and y). For each part, generate all valid number representations (with or without decimal point).

**Algorithm:**
1. For each split of digits into left/right parts.
2. For each part, enumerate valid placements of decimal point.
3. Valid: no leading zeros unless integer "0", no trailing zeros after decimal.
4. Combine all valid (x, y) pairs.

**Complexity:**

| | |
|---|---|
| Time | O(n³) — O(n) splits × O(n) decimal placements each |
| Space | O(n³) — output size |
