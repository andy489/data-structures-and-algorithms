# Solution: Find the K-th Character in String Game II

## Approach: Reverse Simulation (Bit Tracking)

Work backwards from position `k` through the operations.

After each operation, the string doubles in size. For each operation from last to first:
- If `k` is in the first half of the current string, it stays at the same position (the character is unchanged by this operation).
- If `k` is in the second half:
  - For operation type 0 (copy): position maps to `k - half`, character unchanged.
  - For operation type 1 (shift): position maps to `k - half`, character was shifted +1 by this op, so we accumulate a shift count.

Track the total shift count modulo 26 and return `'a' + shift`.

## Complexity

- **Time:** O(len(operations)).
- **Space:** O(1).
