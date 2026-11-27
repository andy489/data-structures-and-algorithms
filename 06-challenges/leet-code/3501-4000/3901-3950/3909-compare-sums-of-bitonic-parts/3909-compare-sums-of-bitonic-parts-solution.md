# Solution for 3909. Compare Sums of Bitonic Parts

## Approach

**Find peak, then sum both parts:**

1. Find the peak index (the element greater than both neighbors, or first/last if on boundary).
2. Sum elements from index 0 to peak (inclusive) → ascending sum.
3. Sum elements from peak to n-1 (inclusive) → descending sum.
4. Compare and return 0, 1, or -1.

**Finding the peak:** Scan for first index where `nums[i] > nums[i+1]`.

## Complexity

- Time: O(n)
- Space: O(1)
