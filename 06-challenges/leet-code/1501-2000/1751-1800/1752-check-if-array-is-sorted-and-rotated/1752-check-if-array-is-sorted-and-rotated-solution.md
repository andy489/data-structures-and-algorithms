# 1752. Check if Array Is Sorted and Rotated — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

---

## Solution: Count Descents — O(n) time, O(1) space

**Idea:** A sorted-and-rotated array has at most one "descent" (position where `nums[i] > nums[i+1]`), and the wrap-around also counts (`nums[n-1] > nums[0]`). If the total number of descents (including wrap-around) is at most 1, the array qualifies.

**Algorithm:**
1. Count positions where `nums[i] > nums[(i+1) % n]`.
2. Return `count <= 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
