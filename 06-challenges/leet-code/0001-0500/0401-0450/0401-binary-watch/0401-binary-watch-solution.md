# 401. Binary Watch — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-watch/

---

## Solution: Bit Count Enumeration — O(1) time, O(1) space

**Idea:** Iterate over all valid hour (0-11) and minute (0-59) combinations. For each pair, if the total number of set bits across both values equals `turnedOn`, it's a valid time.

**Algorithm:**
1. For h in 0..11 and m in 0..59:
2. Count set bits in h and m combined using `Integer.bitCount`.
3. If equal to `turnedOn`, format and add to result.

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed 12×60 = 720 iterations |
| Space | O(1) — output list aside |
