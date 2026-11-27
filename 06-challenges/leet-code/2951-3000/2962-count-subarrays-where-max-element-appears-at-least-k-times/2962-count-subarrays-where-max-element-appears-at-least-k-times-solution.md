# 2962. Count Subarrays Where Max Element Appears at Least K Times — Solution

## Approach: Sliding Window

Find the global maximum `maxVal`. Use a sliding window [left, right]. As we expand right:
- If `nums[right] == maxVal`, increment a counter `cnt`.
- While `cnt >= k`, the current window (and all extensions to the right) are valid. Count = `n - right` for each valid left position. Shrink by incrementing left and updating cnt if `nums[left] == maxVal`.

More precisely: use two pointers. For each right, find the smallest left such that the window contains at least k occurrences of maxVal. All windows [left', right] for left' <= left are valid. Add left to the answer count (they represent valid left endpoints).

## Complexity

| | Time | Space |
|---|---|---|
| Sliding window | O(n) | O(1) |
