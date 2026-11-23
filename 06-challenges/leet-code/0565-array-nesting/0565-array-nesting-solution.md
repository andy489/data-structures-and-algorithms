# Solution: Array Nesting

## Approach
Follow each cycle. Mark visited indices in-place (or with a boolean array) so each index is processed at most once. Track the maximum cycle length.

**Time:** O(n) | **Space:** O(1) (mutating input) or O(n)
