# 2553. Separate the Digits in an Array — Solution

## Approach: String Conversion

For each number in `nums`, convert it to a string and extract each character as a digit. Collect all digits in order.

**Algorithm:**
1. For each number in `nums`, convert to string.
2. For each character in the string, parse back to integer and append to result.

## Complexity

- **Time:** O(n * d) where `d` is the number of digits (at most 6 for `nums[i] <= 10^5`)
- **Space:** O(n * d) — for the result array
