# Solution for 3908. Valid Digit Number

## Approach

**Direct string check:**

1. Convert `n` to a string.
2. Check if the string contains the character `x` (digit `x`).
3. Check if the string does **not** start with `x`.
4. Return `true` iff both conditions hold.

## Complexity

- Time: O(d) where d = number of digits in n
- Space: O(d)
