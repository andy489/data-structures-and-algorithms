# 1536. Minimum Swaps to Arrange a Binary Grid — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/

---

## Solution: Greedy Row Selection — O(n^2) time, O(n) space

**Idea:** For row i (0-indexed), we need at least (n-1-i) trailing zeros to satisfy the upper-triangle constraint. Precompute trailing zeros per row, then greedily find the nearest row (from position i downward) that satisfies the requirement and bubble it up.

**Algorithm:**
1. Compute trailing zeros for each row.
2. For each row position i from 0 to n-1:
   - Need `n - 1 - i` trailing zeros.
   - Find the first row at or after position i with enough trailing zeros.
   - If not found, return -1.
   - Bubble that row up with adjacent swaps, counting swaps.
3. Return total swap count.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — O(n) for each of n rows |
| Space | O(n) — trailing zeros array |
