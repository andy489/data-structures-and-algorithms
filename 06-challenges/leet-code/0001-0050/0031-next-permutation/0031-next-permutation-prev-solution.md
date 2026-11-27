# 31. Previous Permutation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/next-permutation/

---

## Solution: Find Pivot + Swap + Reverse — O(n) time, O(1) space

**Idea:** The mirror of next permutation. The ascending suffix from the right cannot be rearranged into anything smaller — only the element just before it (the "pivot") can be decreased. Swap the pivot with the largest element in the suffix that is strictly smaller than the pivot, then reverse the suffix to put it in descending order — the largest possible arrangement for those positions — yielding the immediately preceding permutation. If no pivot exists the array is already the smallest permutation; reverse it entirely to get the largest.

**Algorithm:**
1. Scan right-to-left to find the rightmost index `i` such that `nums[i] > nums[i + 1]`. If none, reverse the whole array and return.
2. Scan right-to-left to find the rightmost index `j` such that `nums[j] < nums[i]`. Swap `nums[i]` and `nums[j]`.
3. Reverse `nums[i + 1 .. n - 1]` (it was ascending; reversing makes it descending — the largest arrangement for that suffix).

**Complexity:**

| | |
|---|---|
| Time  | O(n) — two linear scans plus one reverse |
| Space | O(1) — in-place |
