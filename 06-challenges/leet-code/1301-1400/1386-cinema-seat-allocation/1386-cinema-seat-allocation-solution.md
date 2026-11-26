# 1386. Cinema Seat Allocation — Solution

## Approach
For each row with reserved seats, use bitmask to check if 2-5, 4-7, or 6-9 are free. Rows without reserved seats can fit 2 groups.

## Complexity
- Time: O(reserved)
- Space: O(reserved)
