# 1482. Minimum Number Of Days To Make M Bouquets — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

---

## Solution: Binary Search — O(n log maxDay) time, O(1) space

**Idea:** Binary search on the answer (day d). Check if on day d we can make m bouquets of k adjacent bloomed flowers.

**Algorithm:**
1. If m*k > n, return -1.
2. Binary search on d in [1, max(bloomDay)].
3. Check(d): scan array, count consecutive bloomed flowers; if >= k, form bouquet. Return #bouquets >= m.

**Complexity:**

| | |
|---|---|
| Time | O(n log maxDay) |
| Space | O(1) |
