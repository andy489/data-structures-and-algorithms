# 31. Next Permutation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/next-permutation/

---

## Solution: Find Pivot + Swap + Reverse — O(n) time, O(1) space

**Idea:** The suffix of the current permutation that is in descending order cannot be rearranged into anything larger — only the element just before this suffix (the "pivot") can be increased. Swap the pivot with the smallest element in the suffix that is still larger than the pivot, then reverse the suffix to get its smallest order, yielding the next permutation overall.

**Algorithm:**
1. Scan right-to-left to find the rightmost index `i` such that `nums[i] < nums[i + 1]` — this is the pivot. If none exists, the array is fully descending (last permutation), so reverse it entirely and return.
2. Scan right-to-left again to find the rightmost index `j` such that `nums[j] > nums[i]`. Swap `nums[i]` and `nums[j]`.
3. Reverse the subarray `nums[i + 1 .. n - 1]` (it was descending; reversing makes it ascending — the smallest arrangement).

**Complexity:**

| | |
|---|---|
| Time  | O(n) — two linear scans plus one reverse, all over the suffix |
| Space | O(1) — all modifications are in-place |
