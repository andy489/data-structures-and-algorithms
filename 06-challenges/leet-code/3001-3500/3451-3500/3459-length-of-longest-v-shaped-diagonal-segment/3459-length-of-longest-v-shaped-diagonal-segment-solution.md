# 3459. Length of Longest V-Shaped Diagonal Segment — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/

---

## Solution: Dynamic Programming on Diagonals — O(n * m) time, O(n * m) space

**Idea:** For each cell, track the longest valid diagonal segment ending at that cell for each of the 4 diagonal directions, with and without having made the clockwise turn. Use DP to extend segments following the sequence 1, 2, 0, 2, 0, ...

**Algorithm:**
1. For each cell (r, c) and each of the 4 diagonal directions (dr, dc), maintain dp[r][c][dir][turned] = max segment length ending here with/without a turn.
2. The expected value at position p in the sequence (after the leading 1) is 2 if p is odd, 0 if p is even.
3. For each starting cell with value 1, try to extend along all diagonal directions, allowing one clockwise 90-degree turn.
4. Track the global maximum length.

**Complexity:**

| | |
|---|---|
| Time | O(n * m) |
| Space | O(n * m) |
