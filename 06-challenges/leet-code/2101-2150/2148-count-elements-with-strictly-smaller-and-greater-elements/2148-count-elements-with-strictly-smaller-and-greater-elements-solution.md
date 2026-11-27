# 2148. Count Elements With Strictly Smaller and Greater Elements — Solution

## Approach: Find Min and Max

**Key insight:** An element qualifies if there exists something strictly smaller AND strictly greater. That means: `element > min(nums) AND element < max(nums)`. So count all elements that are strictly between the global minimum and global maximum.

**Algorithm:**
1. Find the minimum and maximum of `nums`.
2. If `min == max`, return 0 (all elements are equal, none qualify).
3. Count elements `x` where `min < x < max`.

## Complexity

| | Time | Space |
|---|---|---|
| Two passes | O(n) | O(1) |
| **Total** | **O(n)** | **O(1)** |
