# Solution: 2571. Minimum Operations to Reduce an Integer to 0

## Approach: Greedy with Bit Manipulation

The key insight is that adding or subtracting a power of 2 is equivalent to manipulating bits. We want to clear all bits in `n`.

**Observation:** If we look at consecutive set bits (like `0b0111000`), we can either:
1. Clear each bit individually (3 operations for 3 bits)
2. Add `1` to carry over and clear them all at once (2 operations: add to get `0b1000000`, then subtract)

**Algorithm:**
- Count set bits in `n`.
- For consecutive set bits (groups), it's cheaper to carry: if we have k consecutive 1s, we use `k` operations individually but only `2` to carry up. So whenever we see consecutive 1s, we merge them.
- We simulate this by processing bits and counting.

A cleaner approach: use recursion or iteration with bit tricks. When we see consecutive 1 bits (as in a group of 1s in binary), we add to the lower bit to merge them upward.

**Implementation:** 
- Use an integer `val` and greedily process from LSB to MSB.
- When we have isolated 1 bits, subtract the power.
- When we have consecutive 1 bits `011...1`, add 1 to get `100...0` (uses fewer operations).
- Count the number of "runs" of 1 bits in the binary representation — each run contributes at most 2 operations (regardless of run length).

The minimum operations = number of groups of consecutive 1-bits in `n`'s binary representation. Each group can be handled with:
- 1 operation if the group is a single bit
- 2 operations if the group has 2+ bits (add to carry, then subtract the new power of 2)

Wait — a single bit also needs 1 operation. A group of k consecutive bits uses 2 ops: add 1 at the low end to make a new power, then subtract. Unless it's a single bit = 1 op.

Actually: each contiguous group of 1 bits in binary representation costs exactly 2 operations unless it's at the top (the most significant 1-bit run), which costs 1. Actually the minimum ops = number of "runs" of 1s in binary. This can be calculated as follows:
- Each transition from 0→1 (starting a run) or 1→0 (ending a run) in the bit sequence.

**Cleaner formula:** The answer equals the number of "blocks" of consecutive 1s in the binary representation of n, with each block costing at most 2 (and exactly 1 for the highest bit block since we just subtract it).

Actually the simplest approach: count groups of consecutive 1-bits. If `popcount(n)` = 1, answer = 1. Otherwise, the answer equals the number of groups.

## Implementation Note

We iterate over bits and when we find a group of consecutive 1s longer than 1, we add to merge them. We continue until n becomes a power of 2 or zero.

## Complexity

- **Time:** O(log n)
- **Space:** O(1)
