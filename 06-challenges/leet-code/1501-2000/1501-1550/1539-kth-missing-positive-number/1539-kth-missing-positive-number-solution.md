# 1539. Kth Missing Positive Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/kth-missing-positive-number/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** At index `mid` (0-indexed), the number of missing positives before `arr[mid]` is `arr[mid] - (mid + 1)`. Binary search for the leftmost position where this count >= k. The answer is `lo + k`.

**Algorithm:**
1. Binary search on [0, n] where n = arr.length.
2. At each mid, compute missing count = `arr[mid] - (mid + 1)`.
3. If missing >= k, narrow to left half; otherwise narrow to right.
4. After binary search, `lo` is the insertion point; answer is `lo + k`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — binary search |
| Space | O(1) — no extra storage |
