# 1354. Construct Target Array With Multiple Sums — Solution

## Approach
Work backwards from target. Max element was derived from sum. Reverse: element = element % (sum - element), repeat until all 1s.

## Complexity
- Time: O(n log(max))
- Space: O(n)
