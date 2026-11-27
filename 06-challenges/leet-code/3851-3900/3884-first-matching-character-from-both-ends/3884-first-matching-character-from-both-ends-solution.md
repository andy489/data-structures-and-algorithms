# Solution: 3884. First Matching Character From Both Ends

## Approach

Linear scan from index 0 to n/2. For each index `i`, check if `s[i] == s[n-1-i]`. Return the first `i` where this is true. If none found, return -1.

Note: when `i == n-1-i` (middle of odd-length string), the condition is trivially true.

## Complexity

- **Time:** O(n)
- **Space:** O(1)
