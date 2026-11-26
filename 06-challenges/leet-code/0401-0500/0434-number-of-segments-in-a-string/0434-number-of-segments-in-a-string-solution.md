# 434. Number of Segments in a String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-segments-in-a-string/

---

## Solution: Single Pass — O(n) time, O(1) space

**Idea:** Count segment starts: a position is a segment start when the current character is not a space and either it's the first character or the previous character is a space.

**Algorithm:**
1. Iterate through each character.
2. Count positions where `s[i] != ' '` and (`i == 0` or `s[i-1] == ' '`).

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra space |
