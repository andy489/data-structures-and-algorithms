# 1221. Split a String in Balanced Strings — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/split-a-string-in-balanced-strings/

---

## Solution: Greedy Counter — O(n) time, O(1) space

**Idea:** Scan left to right, maintaining a balance counter (+1 for R, -1 for L). Each time balance hits 0, we've found a balanced substring.

**Algorithm:**
1. Maintain balance = 0.
2. For each char: increment for R, decrement for L.
3. When balance == 0, increment answer.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
