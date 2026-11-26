# Solution: Find the Closest Palindrome

## Approach
Generate five candidates and pick the closest (then smallest on tie):
1. Mirror the first half onto the second half (same length).
2. Mirror with the middle digit incremented by 1.
3. Mirror with the middle digit decremented by 1.
4. `10^(len-1) - 1` (all 9s, one digit shorter).
5. `10^len + 1` (101…1, one digit longer).

Pick the candidate with the smallest absolute difference from `n`; on a tie, the smaller value.

**Time:** O(len) | **Space:** O(len)
