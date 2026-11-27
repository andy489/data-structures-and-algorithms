# Solution: 3894. Traffic Signal Color

## Approach: Simple Conditionals

Directly check the timer value against the given rules.

### Algorithm

1. If `timer == 0`, return `"Green"`.
2. If `timer == 30`, return `"Orange"`.
3. If `30 < timer <= 90`, return `"Red"`.
4. Otherwise, return `"Invalid"`.

## Complexity

- **Time:** O(1)
- **Space:** O(1)
