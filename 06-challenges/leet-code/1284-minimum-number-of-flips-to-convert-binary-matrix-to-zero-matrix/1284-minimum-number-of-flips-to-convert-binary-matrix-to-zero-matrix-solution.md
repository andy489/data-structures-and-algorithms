# 1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/

---

## Solution: BFS on Bitmask — O(2^(m*n) * m*n) time, O(2^(m*n)) space

**Idea:** Encode matrix state as bitmask. BFS from initial state. Each step: try flipping each cell. Find minimum steps to reach all-zeros.

**Algorithm:**
1. Encode m*n matrix as bitmask.
2. BFS from initial state.
3. For each state, try all m*n flips.
4. Return steps when 0 is reached.

**Complexity:**

| | |
|---|---|
| Time | O(2^(m*n) * m*n) |
| Space | O(2^(m*n)) |
