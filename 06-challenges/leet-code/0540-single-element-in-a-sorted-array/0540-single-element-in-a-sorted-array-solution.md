# 540. Single Element in a Sorted Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/single-element-in-a-sorted-array/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** Every element appears exactly twice except one. Before the single element, pairs occupy even-odd indices: `nums[i] == nums[i+1]` for even `i`. After the single element, pairs shift: `nums[i] == nums[i-1]` for even `i`.

Binary search on even indices:
- If `nums[mid] == nums[mid+1]`: single element is to the right → `lo = mid + 2`
- Else: single element is at `mid` or to the left → `hi = mid`

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
