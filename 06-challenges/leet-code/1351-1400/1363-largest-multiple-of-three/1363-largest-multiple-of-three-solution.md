# 1363. Largest Multiple of Three — Solution

## Approach
Sum of digits mod 3. If 0, done. If remainder is 1 or 2, greedily remove smallest digit(s) with matching remainder. Build number descending.

## Complexity
- Time: O(n log n)
- Space: O(n)
