# 2563. Count the Number of Fair Pairs — Solution

## Approach: Sort + Binary Search

**Key Insight:** Sort the array. For each element `nums[i]`, use binary search to find the range of valid partners `nums[j]` (where `j > i`) such that `lower <= nums[i] + nums[j] <= upper`. Since the array is sorted, valid `j` indices form a contiguous range.

**Algorithm:**
1. Sort `nums`.
2. For each `i` from 0 to n-1, find:
   - `lo` = leftmost `j > i` with `nums[j] >= lower - nums[i]`
   - `hi` = rightmost `j > i` with `nums[j] <= upper - nums[i]`
3. Add `max(0, hi - lo + 1)` to result.

**Optimization:** Use a helper `countLess(target)` = number of pairs `(i,j)` with `i < j` and `nums[i] + nums[j] < target`. Then answer = `countLess(upper + 1) - countLess(lower)` using two-pointer on the sorted array.

## Complexity

- **Time:** O(n log n) — sorting plus binary search per element
- **Space:** O(1) — ignoring sort space
