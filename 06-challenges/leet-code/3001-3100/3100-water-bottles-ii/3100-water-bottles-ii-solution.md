# 3100. Water Bottles Ii — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/water-bottles-ii/

---

## Solution: Simulation — O(sqrt(numBottles)) time, O(1) space

**Idea:** Simulate: drink all full bottles, accumulate empties, exchange when possible (numExchange increases each time).

**Algorithm:**
1. total = numBottles (drink all). empties = numBottles.
2. While empties >= numExchange: empties -= numExchange; empties++; total++; numExchange++.
3. Return total.

**Complexity:**

| | |
|---|---|
| Time | O(sqrt(numBottles)) — O(sqrt(n)) — exchanges decrease quickly |
| Space | O(1) — O(1) |
