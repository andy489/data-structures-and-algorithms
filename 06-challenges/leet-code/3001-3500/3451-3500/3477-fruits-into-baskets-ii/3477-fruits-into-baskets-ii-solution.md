# 3477. Fruits Into Baskets II — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/fruits-into-baskets-ii/

---

## Solution: Brute Force Simulation — O(n^2) time, O(n) space

**Idea:** For each fruit type, scan baskets from left to right to find the leftmost available basket with sufficient capacity. Mark used baskets.

**Algorithm:**
1. Maintain a boolean array `used` of length `n`.
2. For each fruit at index `i`, iterate `j` from `0` to `n-1`.
3. If `baskets[j] >= fruits[i]` and `!used[j]`, mark `used[j] = true` and move to next fruit.
4. If no basket found, increment unplaced count.
5. Return unplaced count.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
