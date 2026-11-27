# 1642. Furthest Building You Can Reach — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/furthest-building-you-can-reach/

---

## Solution: Min-Heap (Greedy) — O(n log L) time, O(L) space

**Idea:** Use ladders on the largest climbs. Maintain a min-heap of the climbs where we used a ladder. When we run out of ladders, swap the smallest ladder-climb with bricks if bricks can cover it; otherwise stop.

**Algorithm:**
1. For each step where `heights[i+1] > heights[i]`, let `d = heights[i+1] - heights[i]`.
2. Push `d` onto a min-heap and assign a ladder to it.
3. If heap size exceeds `ladders`:
   - Pop the minimum `d` from the heap (the cheapest ladder use).
   - Subtract it from `bricks`.
   - If `bricks < 0`, we cannot proceed — return `i`.
4. Return `heights.length - 1` if we reach the end.

**Complexity:**

| | |
|---|---|
| Time | O(n log L) — each push/pop is O(log L), L = number of ladders |
| Space | O(L) — the heap |
