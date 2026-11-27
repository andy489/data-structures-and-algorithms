# Solution: Check if Bitwise OR Has Trailing Zeros

## Approach: Count Even Numbers

A bitwise OR has trailing zeros only if the last bit is 0. The last bit of OR is 0 only if ALL selected elements have their last bit as 0, i.e., ALL selected elements are even.

So we just need at least 2 even numbers in the array.

## Complexity

| | Time | Space |
|---|---|---|
| **Linear Scan** | **O(n)** | **O(1)** |

## Key Insight

Bitwise OR of values has trailing zero if and only if at least one bit position is 0 across all selected elements. The least significant bit is 0 for all selected elements if and only if all selected elements are even. We need at least 2 elements, so check if there are at least 2 even numbers.
