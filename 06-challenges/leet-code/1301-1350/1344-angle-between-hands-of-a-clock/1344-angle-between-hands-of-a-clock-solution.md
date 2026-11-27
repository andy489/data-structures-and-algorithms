# 1344. Angle Between Hands of a Clock — Solution

## Approach
Minute hand: minutes * 6 degrees. Hour hand: (hour % 12) * 30 + minutes * 0.5 degrees. Return min(diff, 360-diff).

## Complexity
- Time: O(1)
- Space: O(1)
