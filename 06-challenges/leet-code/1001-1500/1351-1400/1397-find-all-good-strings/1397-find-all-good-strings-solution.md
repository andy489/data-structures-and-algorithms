# 1397. Find All Good Strings — Solution

## Approach
Digit DP + KMP. State: (pos, kmpState, tightLower, tightUpper). Count strings avoiding evil pattern.

## Complexity
- Time: O(n * |evil| * 26 * 4)
- Space: O(n * |evil|)
