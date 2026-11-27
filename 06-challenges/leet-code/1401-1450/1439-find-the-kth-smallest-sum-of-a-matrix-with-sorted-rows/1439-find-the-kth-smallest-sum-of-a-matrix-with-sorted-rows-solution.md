# 1439. Find The Kth Smallest Sum Of A Matrix With Sorted Rows — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/

---

## Solution: Min-Heap Merge — O(m * k log k) time, O(k) space

**Idea:** Start with the sums from the first row. For each subsequent row, merge with the new row's elements using a min-heap, keeping only the best k sums.

**Algorithm:**
1. candidates = first row (up to k elements).
2. For each next row: new_sums = [cand + row[j] for each cand, row[j]]; keep only k smallest.
3. Return candidates[k-1].

**Complexity:**

| | |
|---|---|
| Time | O(m * k log k) |
| Space | O(k) |
