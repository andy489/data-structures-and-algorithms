# 2997. Minimum Number of Operations to Make Array XOR Equal to K — Solution

## Approach: XOR + Bit Count

Key insight: each operation flips exactly one bit in one element. The XOR of the entire array changes by flipping that same bit position in the XOR result. So:

1. Compute `xorAll = XOR of all nums`.
2. Compute `diff = xorAll XOR k`. Each set bit in `diff` corresponds to a bit position where `xorAll` and `k` differ.
3. The minimum operations = number of set bits in `diff` (`Integer.bitCount(diff)`), because each operation can fix exactly one differing bit.

## Complexity

| | Time | Space |
|---|---|---|
| XOR all elements | O(n) | O(1) |
| Count differing bits | O(1) | O(1) |
| **Total** | **O(n)** | **O(1)** |
