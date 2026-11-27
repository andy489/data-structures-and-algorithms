# 715. Range Module — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/range-module/

---

## Solution: Sorted List of Disjoint Intervals — O(n) per op, O(n) space

**Idea:** Maintain a sorted list of non-overlapping intervals. For each operation, find overlapping intervals using binary search, merge/update/split as needed.

**Algorithm:**
1. Keep intervals sorted by start. All intervals are disjoint.
2. `addRange(l, r)`: find all intervals that overlap [l, r), merge them into one [min(l, overlap.left), max(r, overlap.right)].
3. `queryRange(l, r)`: find the interval that covers l; check if it also covers r.
4. `removeRange(l, r)`: for each overlapping interval, trim or split it. Keep the non-overlapping parts.

**Complexity:**

| | |
|---|---|
| Time | O(n) per operation in worst case — n overlapping intervals |
| Space | O(n) — total intervals stored |
