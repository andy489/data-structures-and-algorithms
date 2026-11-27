# 2119. A Number After a Double Reversal — Solution

**Link:** https://leetcode.com/problems/a-number-after-a-double-reversal/

## Approach: Mathematical Insight

A double reversal returns the original number if and only if the number does **not** end with a `0` (or the number itself is `0`). If `num` ends with a `0` (and is non-zero), reversing removes the trailing zero, so a second reversal can't restore it.

Key insight: `reversed2 == num` iff `num == 0` or `num % 10 != 0`.

## Complexity

| | Time | Space |
|---|---|---|
| **O(1) check** | O(1) | O(1) |
