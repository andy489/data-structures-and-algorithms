# 374. Guess Number Higher or Lower — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/guess-number-higher-or-lower/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** Standard binary search using the `guess` API to direct the search.

**Algorithm:**
1. `lo = 1, hi = n`.
2. At each `mid`, call `guess(mid)`. If 0, return mid; if -1, go left; if 1, go right.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
