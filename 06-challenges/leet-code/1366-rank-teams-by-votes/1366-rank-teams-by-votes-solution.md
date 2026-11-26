# 1366. Rank Teams by Votes — Solution

## Approach
Count votes per team per rank position. Sort by (-votes at pos 0, -votes at pos 1, ..., team name).

## Complexity
- Time: O(n * m + m^2 log m) where m = teams count
- Space: O(m * m)
