# Solution: Count the Number of Incremovable Subarrays I

## Approach: Brute Force

Given the small constraint (n ≤ 50), try every possible subarray [i, j] and check if removing it makes the remaining array strictly increasing.

For each pair (i, j), construct the remaining array and verify it's strictly increasing.

## Complexity

| | Time | Space |
|---|---|---|
| **Brute Force** | **O(n³)** | **O(n)** |

## Key Insight

n ≤ 50 makes O(n³) trivially feasible. For each subarray removal, check if the concatenation of the prefix [0, i-1] and suffix [j+1, n-1] is strictly increasing and the junction is also valid.
