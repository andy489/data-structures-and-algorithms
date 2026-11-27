# Solution: Minimum Operations to Make Columns Strictly Increasing

## Approach

For each column, iterate top to bottom. Each element must be strictly greater than the previous. If it's not, increment it to `prev + 1` and count the operations.

Process each column independently, tracking how many increments are needed.

## Complexity

| | Complexity |
|---|---|
| Time | O(m * n) |
| Space | O(1) |
