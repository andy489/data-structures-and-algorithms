# Solution: 2595. Number of Even and Odd Bits

## Approach

Iterate through each bit of `n` from right to left (index 0 = rightmost). For each bit position `i`, if bit `i` is set (n >> i & 1 == 1), increment `even` if `i` is even, or `odd` if `i` is odd.

## Complexity

- **Time:** O(log n)
- **Space:** O(1)
