# 3925. Concatenate Array With Reverse — Solution

## Approach: Array Construction

Create a result array of length `2n`. Copy `nums` into the first half, then copy `nums` in reverse order into the second half.

## Complexity

- **Time:** O(n) — single pass to build the result
- **Space:** O(n) — for the output array (not counting input)
