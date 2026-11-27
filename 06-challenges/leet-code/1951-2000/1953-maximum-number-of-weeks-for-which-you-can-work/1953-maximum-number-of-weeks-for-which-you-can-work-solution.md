# 1953. Maximum Number of Weeks for Which You Can Work — Solution

## Approach

Key insight: Let `max` be the largest milestone count and `rest` be the sum of all others. 

- If `max <= rest + 1`: We can work all weeks, returning `max + rest` total weeks.
- Otherwise: We can interleave `rest` other milestones between the max project's milestones, giving `2 * rest + 1` weeks.

**Complexity:** O(n) time, O(1) space.
