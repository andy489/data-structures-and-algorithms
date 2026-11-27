# 1396. Design Underground System — Solution

## Approach
HashMap for active trips (id → (station, time)). HashMap for route stats (route → (totalTime, count)).

## Complexity
- Time: O(1) all operations
- Space: O(P + R) where P=passengers, R=routes
