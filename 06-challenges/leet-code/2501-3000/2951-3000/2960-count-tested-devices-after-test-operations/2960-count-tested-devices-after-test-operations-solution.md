# 2960. Count Tested Devices After Test Operations — Solution

## Approach: Greedy — Track Offset

Instead of updating all future elements (which would be O(n^2)), track the number of devices tested so far as an offset. Device `i` effectively has battery `batteryPercentages[i] - tested_count` (since each previously tested device reduced it by 1). If this adjusted value > 0, we test device i and increment `tested_count`.

## Complexity

| | Time | Space |
|---|---|---|
| Single pass with counter | O(n) | O(1) |
