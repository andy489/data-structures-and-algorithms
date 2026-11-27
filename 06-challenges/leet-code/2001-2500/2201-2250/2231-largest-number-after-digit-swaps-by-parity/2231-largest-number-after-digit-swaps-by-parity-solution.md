# 2231. Largest Number After Digit Swaps by Parity

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/

## Approach: Sorting Digits by Parity

Separate digits into odd and even groups, sort each group descending, then rebuild the number by assigning sorted digits back to their original parity positions.

**Algorithm:**
1. Convert the number to an array of digits.
2. Collect odd digits and even digits separately, sort each descending.
3. Traverse the original digits: for each position, pick the next digit from the appropriate sorted list.
4. Reconstruct and return the number.

**Complexity:**
- Time: O(d log d) where d is the number of digits (at most 10)
- Space: O(d)
