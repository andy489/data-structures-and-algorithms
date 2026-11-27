# Solution: 2600. K Items With the Maximum Sum

## Approach

Greedy: pick items in order of decreasing value.
1. Take as many `1`s as possible (up to `min(k, numOnes)`).
2. With remaining picks, take `0`s (they don't change the sum).
3. With any remaining picks, take `-1`s (each reduces sum by 1).

## Complexity

- **Time:** O(1)
- **Space:** O(1)
