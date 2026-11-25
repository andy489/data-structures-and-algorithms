# 922. Sort Array By Parity II — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sort-array-by-parity-ii/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use an even pointer and an odd pointer. If even-indexed position has odd value, find the next odd-indexed position with even value, and swap.

**Algorithm:**
1. Even pointer starts at 0, odd pointer at 1.
2. When nums[even] is odd: advance odd pointer to find even value at odd index; swap.
3. Advance even by 2.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
