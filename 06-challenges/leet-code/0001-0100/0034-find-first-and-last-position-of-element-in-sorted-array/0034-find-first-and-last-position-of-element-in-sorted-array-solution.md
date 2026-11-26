# 34. Find First and Last Position of Element in Sorted Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

---

## Solution: Unified Binary Search with advance predicate — O(log n) time, O(1) space

**Idea:** Both lower and upper bound searches share identical structure — they differ only in what to do when `nums[mid] == target`. Extract a single `bound(advance)` helper where `advance` is the predicate that drives `lo = mid + 1`: passing `val < target` keeps searching left on a hit (first occurrence); passing `val <= target` keeps searching right (last occurrence). Record `mid` unconditionally whenever `nums[mid] == target` so both branches capture it.

**Algorithm:**
1. Define `bound(advance)`: binary search; on each step record `res = mid` if `nums[mid] == target`, then move right if `advance(nums[mid], target)`, else move left.
2. Call `bound(val < target)` → first occurrence.
3. Call `bound(val <= target)` → last occurrence.
4. Return `[first, last]`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — two independent binary searches |
| Space | O(1) — only pointer variables used |

---

## Solution 2: Lower Bound with target ± 0.5 — O(log n) time, O(1) space

**Idea:** Since the array contains only integers, `target ± 0.5` can never appear in it. A single `lowerBound(x)` — the first index where `nums[i] >= x` — suffices for both boundaries using only strict `<`:

- `lowerBound(target - 0.5)` → first index where `nums[i] >= target` = first occurrence
- `lowerBound(target + 0.5) - 1` → one before the first index where `nums[i] > target` = last occurrence

**Algorithm:**
1. Define `lowerBound(x)`: while `lo <= hi`, set `mid`; if `nums[mid] < x` → `lo = mid + 1`; else → `hi = mid - 1`. Return `lo`.
2. `first = lowerBound(target - 0.5)`, `last = lowerBound(target + 0.5) - 1`.
3. If `first > last` (target absent), return `[-1, -1]`; otherwise return `[first, last]`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — two independent binary searches |
| Space | O(1) — only pointer variables used |
