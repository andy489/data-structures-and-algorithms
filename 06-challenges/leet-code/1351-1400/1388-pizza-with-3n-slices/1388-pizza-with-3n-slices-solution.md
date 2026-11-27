# 1388. Pizza With 3n Slices — Solution

## Approach
Equivalent to: pick n non-adjacent elements from circular array of 3n to maximize sum (like House Robber III on circle). Two passes: [0..3n-2] and [1..3n-1].

## Complexity
- Time: O(n^2)
- Space: O(n^2)
