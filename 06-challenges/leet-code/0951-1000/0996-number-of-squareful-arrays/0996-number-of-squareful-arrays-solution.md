# 996. Number of Squareful Arrays — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-squareful-arrays/

---

## Solution: Backtracking with Deduplication — O(n!) time, O(n) space

**Idea:** Backtrack while ensuring each adjacent pair sums to a perfect square. Skip duplicates.

**Complexity:**

| | |
|---|---|
| Time | O(n!) worst case |
| Space | O(n) — recursion |
