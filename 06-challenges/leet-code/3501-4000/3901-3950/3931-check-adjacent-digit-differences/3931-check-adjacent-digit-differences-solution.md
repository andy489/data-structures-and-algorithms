# 3931. Check Adjacent Digit Differences — Solution

## Approach: Linear Scan

Iterate through adjacent pairs of characters in `s`. For each pair, compute the absolute difference of their digit values. If any difference exceeds 2, return `false`. If all pairs pass, return `true`.

## Complexity

- **Time:** O(n) — single pass through the string
- **Space:** O(1) — constant extra space
