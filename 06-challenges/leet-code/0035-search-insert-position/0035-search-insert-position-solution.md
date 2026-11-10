# 35. Search Insert Position — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/search-insert-position/

---

## Solution: Binary Search (Lower Bound) — O(log n) time, O(1) space

**Idea:** Standard binary search. When the target is not found, the left pointer lands at exactly the position where the target should be inserted to keep the array sorted — this is the classical *lower bound* invariant.

**Algorithm:**
1. Initialize `lo = 0`, `hi = nums.length - 1`.
2. While `lo <= hi`:
   - Compute `mid = lo + (hi - lo) / 2`.
   - If `nums[mid] == target`: return `mid`.
   - If `nums[mid] < target`: search right half — `lo = mid + 1`.
   - Otherwise: search left half — `hi = mid - 1`.
3. Loop exits when `lo > hi`; at this point `lo` is the insertion index.

**Why `lo` is the answer on miss:**  
The loop maintains the invariant that all elements in `[0, hi]` are `< target` or all elements in `[lo, n-1]` are `> target` at exit. When it terminates, `lo` points to the first element `>= target`, which is exactly where target would be inserted.

**Complexity:**

| | |
|---|---|
| Time  | O(log n) — search space halves each iteration |
| Space | O(1) — only a few index variables |

---

## Worked Example — `nums = [1,3,5,6]`, `target = 2`

| lo | hi | mid | nums[mid] | action |
|----|----|-----|-----------|--------|
| 0  | 3  | 1   | 3         | 3 > 2 → hi = 0 |
| 0  | 0  | 0   | 1         | 1 < 2 → lo = 1 |
| 1  | 0  | —   | —         | lo > hi → exit |

**Answer: `lo = 1`** ✓ (insert 2 between 1 and 3)
