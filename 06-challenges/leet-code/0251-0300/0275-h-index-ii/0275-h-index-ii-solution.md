# 275. H-Index II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/h-index-ii/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** Since the array is sorted ascending, the number of papers with at least `citations[i]` citations is `n - i`. We want the largest `h` such that `citations[n - h] >= h`. Binary search for the leftmost index where `citations[mid] >= n - mid`.

**Algorithm:**
1. Binary search with `lo = 0`, `hi = n`.
2. At `mid`, if `citations[mid] >= n - mid`, move `hi = mid` (this mid qualifies, try smaller index).
3. Otherwise move `lo = mid + 1`.
4. Return `n - lo`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — binary search |
| Space | O(1) — no extra space |
