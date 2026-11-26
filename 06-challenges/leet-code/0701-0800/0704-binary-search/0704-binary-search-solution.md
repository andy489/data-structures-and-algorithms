# 704. Binary Search — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-search/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** Maintain left and right pointers. At each step compute mid and compare `nums[mid]` to target. Narrow the search range accordingly.

**Algorithm:**
1. Set `lo = 0`, `hi = nums.length - 1`.
2. While `lo <= hi`: compute `mid = lo + (hi - lo) / 2`.
3. If `nums[mid] == target`, return `mid`. If `< target`, set `lo = mid + 1`. Else `hi = mid - 1`.
4. Return `-1`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
