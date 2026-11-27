# 473. Matchsticks to Square — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/matchsticks-to-square/

---

## Solution: Backtracking with Bitmask — O(4^N) time, O(N) space

**Idea:** Each side of the square must equal `sum/4`. Sort descending for early pruning. Try assigning each matchstick to one of the 4 sides using backtracking.

**Algorithm:**
1. If total sum % 4 != 0, return false.
2. Sort descending; if largest > target, return false.
3. DFS: for each stick, try adding to each side that won't exceed target.
4. Skip sides with same current length (avoid duplicate work).

**Complexity:**

| | |
|---|---|
| Time | O(4^N) worst case with pruning typically much better |
| Space | O(N) — recursion stack |

---

## Solution 2: DP Bitmask — O(N · 2^N) time, O(2^N) space

**Idea:** Use bitmask DP. For each subset, compute its sum. Build target side by side.

**Complexity:**

| | |
|---|---|
| Time | O(N · 2^N) |
| Space | O(2^N) |
