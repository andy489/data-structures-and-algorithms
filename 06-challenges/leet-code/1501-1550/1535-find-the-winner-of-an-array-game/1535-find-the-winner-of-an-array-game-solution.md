# 1535. Find the Winner of an Array Game — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-winner-of-an-array-game/

---

## Solution: Single Pass Simulation — O(n) time, O(1) space

**Idea:** Instead of actually moving elements, we simulate the process. The "current" winner plays against each subsequent element. If k is large enough that no one wins before we exhaust the array, the global maximum (which is current after full traversal) wins.

**Algorithm:**
1. Start with `current = arr[0]`, `wins = 0`.
2. For each element from index 1 onwards:
   - If it beats current, update current and reset wins to 1.
   - Otherwise increment wins.
   - If wins >= k, return current.
3. If loop ends without finding a k-winner, return current (the max seen so far).

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the array |
| Space | O(1) — only two variables |
