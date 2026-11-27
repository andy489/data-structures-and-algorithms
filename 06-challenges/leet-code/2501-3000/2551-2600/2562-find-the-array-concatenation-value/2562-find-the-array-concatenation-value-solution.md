# 2562. Find the Array Concatenation Value — Solution

## Approach: Two Pointers

Use two pointers `l` (left) and `r` (right). While `l < r`, concatenate `nums[l]` and `nums[r]` by computing `nums[l] * 10^(digits of nums[r]) + nums[r]`. If `l == r`, just add `nums[l]`. Advance pointers inward.

## Complexity

- **Time:** O(n * d) where `d` is max digit count (at most 5 for `nums[i] <= 10^4`)
- **Space:** O(1) — constant extra space
