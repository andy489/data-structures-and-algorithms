# 581. Shortest Unsorted Continuous Subarray — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

---

## Solution 1: Two-pass Linear Scan — O(n) time, O(1) space

**Idea:** Find the leftmost and rightmost positions where the array is out of order. The left boundary is the first index where `nums[i] > nums[i+1]`, but we need to extend it to cover any elements in the subarray that are smaller than the min in the right part. Use two passes: left-to-right to find rightmost misfit, right-to-left to find leftmost misfit.

**Algorithm:**
1. Scan left-to-right tracking running max; when `nums[i] < runningMax`, update `right = i`.
2. Scan right-to-left tracking running min; when `nums[i] > runningMin`, update `left = i`.
3. Answer is `right - left + 1` (or 0 if right == -1).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

## Solution 2: Sort and Compare — O(n log n) time, O(n) space

**Idea:** Sort a copy of the array and find the first and last positions where the original differs from the sorted version.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
