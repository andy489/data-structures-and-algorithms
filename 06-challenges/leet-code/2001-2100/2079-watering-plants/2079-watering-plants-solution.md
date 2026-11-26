# 2079. Watering Plants — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/watering-plants/

---

## Solution: Simulation — O(n) time, O(1) space

**Idea:** Walk right, refilling when needed. Track current water and position.

**Algorithm:**
1. Start at pos=-1, water=capacity.
2. For each plant i: if water < plants[i], walk back to river (cost: 2*(i)) and refill, then walk to plant.
3. Walk to next plant (+1 step).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
