# 1316. Distinct Echo Substrings — Solution

## Approach
For each even length 2k, use rolling hash to check all substrings of length 2k: compare first half hash with second half hash.

## Complexity
- Time: O(n^2)
- Space: O(n)
