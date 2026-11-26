# 1318. Minimum Flips to Make a OR b Equal to c — Solution

## Approach
For each bit: if c-bit=1, need at least one of a,b to be 1 (flip if both 0). If c-bit=0, need both a,b to be 0 (count how many are 1).

## Complexity
- Time: O(log max(a,b,c))
- Space: O(1)
