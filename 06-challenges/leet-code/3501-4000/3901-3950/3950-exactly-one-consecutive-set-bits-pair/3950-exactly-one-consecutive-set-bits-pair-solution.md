# 3950. Exactly One Consecutive Set Bits Pair

## Approach

Count the number of adjacent pairs of set bits in the binary representation of `n`. Check bit `i` and bit `i+1`; if both are 1, increment a counter. Return `true` if the counter equals exactly 1.

Equivalent bit trick: `n & (n >> 1)` gives a number where each set bit corresponds to an adjacent pair of set bits in `n`. We need this result to have exactly 1 set bit, i.e., `Integer.bitCount(n & (n >> 1)) == 1`.

## Complexity

- **Time:** O(log n) — scanning bits
- **Space:** O(1)
