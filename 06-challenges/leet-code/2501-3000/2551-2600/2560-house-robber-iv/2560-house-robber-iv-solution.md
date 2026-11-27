# 2560. House Robber IV — Solution

## Approach: Binary Search on Answer

**Key Insight:** Binary search on the capability value `cap`. For a given `cap`, greedily count the maximum number of non-adjacent houses with values `<= cap`. If this count is `>= k`, the answer can be at most `cap`.

**Check function (canRob(cap, k)):**
- Greedily rob houses from left to right: rob house `i` if `nums[i] <= cap` and the previous house was not robbed.
- Count total robbed houses; return `count >= k`.

**Binary Search:**
- Low = min(nums), High = max(nums).
- Find the smallest `cap` for which `canRob(cap, k)` is true.

## Complexity

- **Time:** O(n log(max_val)) — binary search with O(n) check each time
- **Space:** O(1) — constant extra space
