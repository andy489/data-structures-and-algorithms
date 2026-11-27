# 3936. Minimum Swaps to Move Zeros to End

## Approach

Use a two-pointer technique. Keep a write pointer pointing to the leftmost position where a zero should be placed. Scan the array from left to right; whenever we see a non-zero element that is at or after the write pointer, place it at the write pointer and move the write pointer forward.

A simpler equivalent: count how many zeros appear before each non-zero element. For each non-zero element at index `i`, it needs to pass over all zeros that are to its left. The total number of such passes is the answer.

Actually the cleanest approach: use a pointer `pos` that tracks where the next non-zero should go. For each element, if it is non-zero, it may need to swap with a zero at position `pos`. The count of swaps equals the number of non-zero elements that have at least one zero to their left.

Equivalent: iterate with a write pointer `pos`. For each index `i`, if `nums[i] != 0`, place it at `pos` and increment `pos`. Number of swaps = number of positions where `nums[i] != 0` and `i > pos`.

## Complexity

- **Time:** O(n) — single pass
- **Space:** O(1) — in-place with two pointers
