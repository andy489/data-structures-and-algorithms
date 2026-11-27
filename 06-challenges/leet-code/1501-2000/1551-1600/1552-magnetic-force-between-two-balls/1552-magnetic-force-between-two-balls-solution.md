# 1552. Magnetic Force Between Two Balls — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/magnetic-force-between-two-balls/

---

## Solution: Binary Search on Answer — O(n log n + n log D) time, O(1) space

**Idea:** Binary search on the minimum distance value. For a given minimum distance `d`, greedily check if `m` balls can be placed such that consecutive balls are at least `d` apart. The feasibility function is monotone, so binary search applies.

**Algorithm:**
1. Sort positions.
2. Binary search on the minimum distance in range `[1, max - min]`.
3. For each candidate `mid`, greedily place balls starting from the first position, moving to the next only when the gap is >= `mid`.
4. If `m` balls can be placed, increase the lower bound; otherwise decrease the upper bound.

**Complexity:**

| | |
|---|---|
| Time | O(n log n + n log D) — sorting plus binary search with O(n) check each step |
| Space | O(1) — after sorting in-place |
