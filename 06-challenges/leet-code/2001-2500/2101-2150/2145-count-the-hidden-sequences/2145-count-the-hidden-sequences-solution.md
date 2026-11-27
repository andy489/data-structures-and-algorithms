# 2145. Count the Hidden Sequences — Solution

## Approach: Prefix Sum + Range Sliding

**Key insight:** Fix `hidden[0] = 0` and compute prefix sums to find the minimum and maximum values the sequence can take. The actual range of the sequence is `[minVal, maxVal]`. The sequence can start at any value `x` such that `x + minVal >= lower` and `x + maxVal <= upper`. Count how many valid starting values exist.

**Algorithm:**
1. Compute prefix sums starting with `hidden[0] = 0`.
2. Track the minimum and maximum prefix sum values.
3. The sequence spans `maxVal - minVal` range. The number of valid starting points is `(upper - lower) - (maxVal - minVal) + 1`, clamped to 0.

## Complexity

| | Time | Space |
|---|---|---|
| Single pass | O(n) | O(1) |
| **Total** | **O(n)** | **O(1)** |
