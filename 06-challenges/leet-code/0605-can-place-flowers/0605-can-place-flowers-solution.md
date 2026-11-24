# 605. Can Place Flowers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/can-place-flowers/

---

## Solution: Greedy Scan — O(n) time, O(1) space

**Idea:** Greedily plant a flower at every eligible empty cell (both neighbors are 0 or out of bounds), then check if placed >= n.

**Algorithm:**
1. Scan left to right.
2. For each cell i where `flowerbed[i] == 0`, check that `flowerbed[i-1] != 1` and `flowerbed[i+1] != 1` (treat out-of-bounds as 0).
3. If plantable, set `flowerbed[i] = 1` and increment count.
4. Return `count >= n`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — in-place modification |
