# 905. Sort Array By Parity — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sort-array-by-parity/

---

## Solution: Two Pointers (In-Place) — O(n) time, O(1) space

**Idea:** Use two pointers from both ends. Swap when left is odd and right is even.

**Algorithm:**
1. `left = 0, right = n-1`.
2. While left < right: advance left while even, retreat right while odd, swap if still left < right.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
