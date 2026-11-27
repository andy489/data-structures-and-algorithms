# 378. Kth Smallest Element in a Sorted Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

---

## Solution 1: Binary Search on Value — O(n log(max-min)) time, O(1) space

**Idea:** Binary search on the answer value. For a candidate `mid`, count how many elements are `≤ mid` using the sorted-row property.

**Algorithm:**
1. `lo = matrix[0][0]`, `hi = matrix[n-1][n-1]`.
2. While `lo < hi`: count elements `≤ mid`. If count `< k`, go right; else go left.
3. `countLessEqual(mid)`: for each row, binary search the rightmost element `≤ mid`.

**Complexity:**

| | |
|---|---|
| Time | O(n log(max - min)) |
| Space | O(1) |

---

## Solution 2: Min-Heap — O(k log n) time, O(n) space

**Idea:** Seed heap with first element of each row. Pop `k` times, re-inserting the next element in the same row.

**Complexity:**

| | |
|---|---|
| Time | O(k log n) |
| Space | O(n) |
