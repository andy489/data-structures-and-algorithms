# 2951. Find the Peaks — Solution

## Approach: Linear Scan

Iterate through indices 1 to n-2 (excluding first and last). For each index, check if the element is strictly greater than both neighbors.

## Complexity

| | Time | Space |
|---|---|---|
| Find the Peaks | O(n) | O(1) extra (output not counted) |
