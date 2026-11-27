# 2130. Maximum Twin Sum of a Linked List — Solution

**Link:** https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

## Approach: Reverse Second Half

1. Find the middle of the list using slow/fast pointers.
2. Reverse the second half of the list.
3. Walk both halves together, computing the twin sums, tracking the maximum.

This avoids using extra space for storing all values.

## Complexity

| | Time | Space |
|---|---|---|
| **Reverse Half** | O(n) | O(1) |

Where `n` is the number of nodes in the linked list.
