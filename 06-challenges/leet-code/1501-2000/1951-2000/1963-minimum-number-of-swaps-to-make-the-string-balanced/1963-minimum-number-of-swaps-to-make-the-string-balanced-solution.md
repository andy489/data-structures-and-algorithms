# 1963. Minimum Number of Swaps to Make the String Balanced — Solution

## Approach

Track unmatched closing brackets. Use a counter: increment for ']', decrement (if positive) for '['. The count of unmatched ']' at the end is `unmatched`. Each swap fixes 2 unmatched brackets, so the answer is ceil(unmatched / 2).

**Complexity:** O(n) time, O(1) space.
