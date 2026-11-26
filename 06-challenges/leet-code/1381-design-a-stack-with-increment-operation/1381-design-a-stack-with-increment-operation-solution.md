# 1381. Design a Stack With Increment Operation — Solution

## Approach
Lazy increment: store increments in a separate array. Add val at index min(k,top)-1. On pop, propagate increment down.

## Complexity
- Time: O(1) all operations
- Space: O(maxSize)
