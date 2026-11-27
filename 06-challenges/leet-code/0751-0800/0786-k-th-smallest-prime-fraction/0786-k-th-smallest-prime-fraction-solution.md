# 786. K-th Smallest Prime Fraction — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/k-th-smallest-prime-fraction/

---

## Solution: Min-Heap — O(k log n) time, O(n) space

**Idea:** Use a min-heap seeded with fractions `arr[i]/arr[n-1]` for all i. Pop k times, each time pushing the next fraction in the same row (smaller denominator).

**Algorithm:**
1. Push `(arr[i]/arr[n-1], i, n-1)` for all i < n-1.
2. Pop k-1 times; each pop of `(_, i, j)` pushes `(arr[i]/arr[j-1], i, j-1)` if j-1 > i.
3. The k-th pop gives the answer.

**Complexity:**

| | |
|---|---|
| Time | O(k log n) — k heap ops |
| Space | O(n) — heap size |
