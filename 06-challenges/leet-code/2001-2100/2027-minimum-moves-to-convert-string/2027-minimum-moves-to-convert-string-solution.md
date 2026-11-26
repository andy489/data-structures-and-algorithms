# 2027. Minimum Moves to Convert String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-moves-to-convert-string/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** Greedily cover each 'X' with a window of 3 starting at that X.

**Algorithm:**
1. Scan left to right.
2. When 'X' found, increment moves, skip next 2 characters.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
