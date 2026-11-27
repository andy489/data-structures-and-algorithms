# 2566. Maximum Difference by Remapping a Digit — Solution

## Approach: String Replacement

**To maximize:** Replace the first non-9 digit found with 9. If all digits are 9, the number is already max.

**To minimize:** Replace the first digit (leading digit) with 0 — this gives the minimum value (which may have leading zeros, but the numeric value is still computed correctly).

**Algorithm:**
1. Convert `num` to string.
2. For maximum: find the first digit != '9', replace all its occurrences with '9', parse back.
3. For minimum: replace all occurrences of the first digit with '0', parse back.
4. Return max - min.

## Complexity

- **Time:** O(d) where `d` is the number of digits (at most 9)
- **Space:** O(d) — for string manipulation
