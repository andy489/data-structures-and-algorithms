# 2105. Watering Plants II — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/watering-plants-ii/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use two pointers `l` (Alice's position) and `r` (Bob's position) moving toward each other. At each step, the pointer that is behind (or we process both when they are at different positions, and handle the meeting point separately).

**Algorithm:**
1. Initialize `l = 0`, `r = n - 1`, `waterA = capacityA`, `waterB = capacityB`, `refills = 0`.
2. While `l < r`:
   - Alice waters plant `l`: if `waterA < plants[l]`, refill (`refills++`, `waterA = capacityA`). Then `waterA -= plants[l]`, advance `l`.
   - Bob waters plant `r`: if `waterB < plants[r]`, refill (`refills++`, `waterB = capacityB`). Then `waterB -= plants[r]`, decrement `r`.
3. If `l == r` (they meet at the same plant): the one with more water waters it; if they have the same amount, Alice does. If neither has enough, refill once.
4. Return `refills`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single two-pointer pass |
| Space | O(1) — constant extra variables |
