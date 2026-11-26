# 1518. Water Bottles — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/water-bottles/

---

## Solution: Simulation — O(log(numBottles) / log(numExchange)) time, O(1) space

**Idea:** Simulate the drinking and exchanging process. Drink all full bottles, accumulate empties, exchange as many as possible for new full bottles, repeat.

**Algorithm:**
1. `drunk = 0`, `empty = 0`.
2. While `numBottles > 0`:
   - `drunk += numBottles`, `empty += numBottles`.
   - `numBottles = empty / numExchange`, `empty = empty % numExchange`.
3. Return `drunk`.

**Complexity:**

| | |
|---|---|
| Time | O(log_{numExchange}(numBottles)) — bottles decrease geometrically |
| Space | O(1) — constant extra |
