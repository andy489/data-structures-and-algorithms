# 1710. Maximum Units on a Truck — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-units-on-a-truck/

---

## Solution: Greedy Sort — O(n log n) time, O(1) space

**Idea:** Greedily load boxes with the most units first. Sort by units per box descending, then fill the truck taking as many boxes of each type as possible.

**Algorithm:**
1. Sort `boxTypes` by `numberOfUnitsPerBox` descending.
2. Iterate through box types, taking min(available, remaining capacity) boxes.
3. Accumulate units; stop when truck is full.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(1) — in-place sort |
