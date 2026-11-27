# Solution: 3417. Zigzag Grid Traversal With Skip

**Link:** https://leetcode.com/problems/zigzag-grid-traversal-with-skip/

## Approach

Simulate the zigzag traversal with a skip counter.

- Use a boolean flag to track direction (left-to-right vs right-to-left).
- Use a skip counter (0 or 1) to skip alternate cells globally across the entire traversal.
- For each row: iterate either left-to-right or right-to-left, adding cells when skip counter is even (0), then flip direction.

## Complexity

- Time: O(m * n)
- Space: O(1) extra (excluding output)
