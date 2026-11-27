# Solution: 2578. Split With Minimum Sum

## Approach: Greedy — Sort Digits and Distribute Alternately

To minimize `num1 + num2`, we want to minimize the contribution of each digit to the most significant positions.

**Key Insight:** Sort the digits in ascending order. Then distribute digits to `num1` and `num2` alternately (odd positions → num1, even positions → num2). This ensures that the most significant digits (which contribute most to the sum) are as small as possible.

**Example:** `num = 4325` → sorted digits: `[2, 3, 4, 5]`
- `num1` gets digits at positions 0, 2: `2, 4` → `24`
- `num2` gets digits at positions 1, 3: `3, 5` → `35`
- Sum = 59 ✓

**Why this works:** If we have digits `d1 <= d2 <= ... <= dk` and want to form two numbers with minimum sum, the optimal strategy minimizes the place values assigned to larger digits. By alternating, we ensure that one number doesn't get all the high-order digits.

## Complexity

- **Time:** O(d log d) where d = number of digits in `num` (at most 10)
- **Space:** O(d)
