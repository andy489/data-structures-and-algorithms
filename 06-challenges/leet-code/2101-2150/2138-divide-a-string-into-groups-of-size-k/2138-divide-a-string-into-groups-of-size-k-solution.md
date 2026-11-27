# 2138. Divide a String Into Groups of Size k — Solution

**Link:** https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/

## Approach: Pad and Split

1. Pad the string with `fill` characters until its length is a multiple of `k`.
2. Slice the padded string into chunks of size `k`.

## Complexity

| | Time | Space |
|---|---|---|
| **Pad and Split** | O(n) | O(n) |

Where `n` is the padded string length.
