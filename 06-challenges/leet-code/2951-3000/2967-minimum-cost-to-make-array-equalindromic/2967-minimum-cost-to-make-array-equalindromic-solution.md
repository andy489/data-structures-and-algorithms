# Solution: Minimum Cost to Make Array Equalindromic

## Approach: Median + Nearest Palindrome

The minimum cost to make all elements equal is minimized when we pick the median. However, the target must be a palindrome. We find the median of the sorted array, then find the nearest palindrome to the median and compute the cost.

We check two candidates: the nearest palindrome ≤ median and the nearest palindrome ≥ median.

## Complexity

| | Time | Space |
|---|---|---|
| **Sort + Median** | **O(n log n)** | **O(1)** |

## Key Insight

For minimizing sum of absolute differences, the median minimizes the total cost. Since the palindrome closest to the median may be on either side, we check the nearest palindrome in both directions and take the minimum cost.
