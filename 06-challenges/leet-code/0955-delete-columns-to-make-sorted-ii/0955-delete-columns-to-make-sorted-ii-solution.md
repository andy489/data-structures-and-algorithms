# 955. Delete Columns to Make Sorted II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-columns-to-make-sorted-ii/

---

## Solution: Greedy Column Scan — O(n*m) time, O(n) space

**Idea:** Track which adjacent row pairs are already strictly sorted. For each column, only add it if it doesn't violate order for pairs not yet decided.

**Algorithm:**
1. Keep `sorted[]` array tracking which adjacent pairs are already strictly ordered.
2. For each column, check if any unsorted pair has the column in reverse order → delete it.
3. Otherwise keep it and update sorted pairs.

**Complexity:**

| | |
|---|---|
| Time | O(n*m) — n rows, m columns |
| Space | O(n) — sorted array |
