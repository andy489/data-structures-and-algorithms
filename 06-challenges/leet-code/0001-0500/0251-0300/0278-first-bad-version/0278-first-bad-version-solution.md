# 278. First Bad Version — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/first-bad-version/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** The versions form a sorted array of `[false...false, true...true]`. Binary search for the leftmost `true` (bad version). If `isBadVersion(mid)` is true, the first bad version is at or before `mid`, so move `hi = mid`. Otherwise move `lo = mid + 1`.

**Algorithm:**
1. `lo = 1`, `hi = n`.
2. While `lo < hi`: `mid = lo + (hi - lo) / 2`.
3. If `isBadVersion(mid)`, set `hi = mid`, else `lo = mid + 1`.
4. Return `lo`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — binary search |
| Space | O(1) — no extra space |
