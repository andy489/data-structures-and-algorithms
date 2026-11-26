# 1291. Sequential Digits — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sequential-digits/

---

## Solution: Enumeration — O(1) time, O(1) space

**Idea:** Generate all sequential-digit numbers by sliding a window over '123456789'. There are only 36 such numbers total.

**Algorithm:**
1. Iterate over all window lengths (2..9) and all starting positions.
2. Build the number and check if it's in [low, high].

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
