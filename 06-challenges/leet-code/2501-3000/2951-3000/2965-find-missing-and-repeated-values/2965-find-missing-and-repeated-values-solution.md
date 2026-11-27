# Solution: Find Missing and Repeated Values

## Approach: Frequency Count

Flatten the n×n grid into a 1D list and count element frequencies. The element with frequency 2 is the repeated value; the element in [1, n²] with frequency 0 is the missing value.

## Complexity

| | Time | Space |
|---|---|---|
| Brute Force | O(n²) | O(n²) |
| **Frequency Array** | **O(n²)** | **O(n²)** |

## Key Insight

Since values are in [1, n²], we can use a counting array of size n²+1. One pass to count, one pass to identify repeated and missing.
