# 1648. Sell Diminishing-Valued Colored Balls — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sell-diminishing-valued-colored-balls/

---

## Solution: Greedy with Sorted Levels — O(n log n) time, O(n) space

**Idea:** Always sell from the color(s) with the highest current count. Sort the inventory and process levels. At each distinct "top" value, determine how many orders can be filled by draining all colors at that level before the next level below.

**Algorithm:**
1. Sort `inventory` in descending order.
2. Process level by level: at each step, the top value is `inv[i]` and there are `i+1` colors at that value or above.
3. For each level, the number of balls available = `(inv[i] - next_level) * count`.
4. If `orders >= balls`, sell all and move down; otherwise distribute `orders` evenly and handle the remainder.
5. Use arithmetic series sum for each layer.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(1) extra |
