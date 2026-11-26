# 148. Sort List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sort-list/

---

## Solution 1: Top-Down Merge Sort — O(n log n) time, O(log n) space

**Idea:** Split the list in half using slow/fast pointers, recursively sort each half, then merge. Standard merge sort on a linked list.

**Algorithm:**
1. Base case: `null` or single node — return as-is.
2. Find the midpoint with slow/fast pointers; split into two halves.
3. Recursively sort left and right halves.
4. Merge the two sorted halves.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — log n split levels, O(n) merge per level |
| Space | O(log n) — recursion stack |

---

## Solution 2: Bottom-Up Merge Sort — O(n log n) time, O(1) space

**Idea:** Iteratively merge sublists of size 1, 2, 4, … until the whole list is sorted. Uses a dummy head to avoid special-casing the front. Satisfies the O(1)-space follow-up.

**Algorithm:**
1. Count list length `n`.
2. For `size = 1, 2, 4, …, n`:
   - Walk the list, splitting pairs of `size`-length sublists, merging them, and re-linking.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) — iterative, no recursion stack |
