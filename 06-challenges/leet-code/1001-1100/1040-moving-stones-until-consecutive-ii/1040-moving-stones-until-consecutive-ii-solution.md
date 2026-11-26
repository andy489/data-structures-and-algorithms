# 1040. Moving Stones Until Consecutive II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/moving-stones-until-consecutive-ii/

---

## Solution: Sorting + Sliding Window — O(n log n) time, O(1) space

**Idea:** Max = (max-min-1) - (n-2) gaps already occupied. For min: use sliding window to find window of size n with most stones already inside.

**Algorithm:**
1. Sort stones.
2. Max = stones[n-1]-stones[0]-1-(n-2) adjusted for endpoint moves.
3. Min: sliding window of size n: for each right pointer, count stones in window; if n-1 consecutive stones in window with one gap, need 2 moves, else n - window_size.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
