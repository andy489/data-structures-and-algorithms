# 1603. Design Parking System — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/design-parking-system/

---

## Solution: Counter Array — O(1) time, O(1) space

**Idea:** Store the available slot counts in an array indexed by car type (1, 2, 3). On each `addCar` call, decrement if the count is positive and return whether a slot was available.

**Algorithm:**
1. Store counts in `slots[0..3]` where index 1 = big, 2 = medium, 3 = small.
2. `addCar(carType)`: return `slots[carType]-- > 0`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — each operation is constant |
| Space | O(1) — fixed-size array of 4 integers |
