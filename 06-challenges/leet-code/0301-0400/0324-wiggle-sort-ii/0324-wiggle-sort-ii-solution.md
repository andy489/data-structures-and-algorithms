# 324. Wiggle Sort II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/wiggle-sort-ii/

---

## Solution: Sort + Interleave — O(n log n) time, O(n) space

**Idea:** Sort the array, split into two halves: smaller half and larger half. Interleave them in reverse order (from largest of each half) so that equal elements are never adjacent.

**Algorithm:**
1. Sort `nums`.
2. Split: `small = nums[0..mid]`, `large = nums[mid+1..n-1]`.
3. Fill `nums` at odd indices with elements from `large` (descending), even indices from `small` (descending).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(n) — copy of sorted array |
