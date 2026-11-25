# 667. Beautiful Arrangement II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/beautiful-arrangement-ii/

---

## Solution: Zigzag Construction — O(n) time, O(n) space

**Idea:** To get exactly k distinct differences, interleave the first k+1 elements in a zigzag pattern (1, k+1, 2, k, 3, k-1, ...). The last n-k-1 elements are appended in order.

**Algorithm:**
1. Place `lo=1, hi=k+1` alternating until k+1 elements are placed.
2. Append `k+2` through `n` in order.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — output array |
