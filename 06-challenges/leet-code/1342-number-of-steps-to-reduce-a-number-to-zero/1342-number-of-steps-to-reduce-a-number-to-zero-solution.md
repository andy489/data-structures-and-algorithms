# 1342. Number of Steps to Reduce a Number to Zero — Solution

## Approach
Simulate: each bit (except leading) requires 2 steps (subtract 1 then divide), leading bit 1 requires 1 step.

## Complexity
- Time: O(log n)
- Space: O(1)
