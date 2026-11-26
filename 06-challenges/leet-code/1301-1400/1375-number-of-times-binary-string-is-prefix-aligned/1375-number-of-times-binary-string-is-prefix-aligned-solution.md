# 1375. Number of Times Binary String Is Prefix-Aligned — Solution

## Approach
Track max index flipped so far. If max == step count (all 1..i flipped), it's prefix-aligned.

## Complexity
- Time: O(n)
- Space: O(1)
