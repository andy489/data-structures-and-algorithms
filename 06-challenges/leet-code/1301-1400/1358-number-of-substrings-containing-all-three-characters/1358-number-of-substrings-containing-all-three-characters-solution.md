# 1358. Number of Substrings Containing All Three Characters — Solution

## Approach
Track last seen index of a, b, c. For each right, count = 1 + min(last[a], last[b], last[c]).

## Complexity
- Time: O(n)
- Space: O(1)
