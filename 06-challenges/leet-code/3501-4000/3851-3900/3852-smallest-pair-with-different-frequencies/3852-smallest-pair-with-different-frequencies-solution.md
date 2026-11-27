# 3852. Smallest Pair With Different Frequencies — Solution

**Link:** https://leetcode.com/problems/smallest-pair-with-different-frequencies/

## Approach: Frequency Map + Brute Force

1. Build a frequency map of all values in `nums`.
2. Collect all unique values sorted in ascending order.
3. For each pair `(x, y)` with `x < y`, check if their frequencies differ.
4. Return the first such pair found (smallest `x`, then smallest `y`).

Since `nums.length <= 100` and values are in `[1, 100]`, the number of distinct values is at most 100 and the number of pairs is at most O(100^2) = 10,000, so brute force is perfectly fine.

## Complexity

- **Time:** O(V^2) where V is the number of distinct values (≤ 100)
- **Space:** O(V) for the frequency map
