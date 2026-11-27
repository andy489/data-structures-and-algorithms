# 3869. Count Fancy Numbers in a Range — Solution

**Link:** https://leetcode.com/problems/count-fancy-numbers-in-a-range/

## Approach: Digit DP — count(r) - count(l-1)

Use digit DP to count fancy numbers in [1, n]. Then answer = count(r) - count(l-1).

**Is a number good?** Its digits are strictly increasing or strictly decreasing.

**Is a number fancy?** It's good, OR its digit sum is good.

The digit sum of a number up to 10^15 (at most 15 digits, each 0-9) is at most 15*9 = 135. We can precompute which digit sums are "good" (1 or 2 digit numbers whose digits are strictly monotone — which for ≤ 135 means: single digit 1-9, or two-digit where tens-digit != units-digit; actually for numbers ≤ 135, they're at most 3-digit. We need strictly increasing or decreasing digit sequence).

**DP State:** `dp[pos][tight][digitSum][prevDigit][increasing][decreasing][started]`
- pos: current digit position
- tight: whether we're bounded by n's digits
- digitSum: running digit sum
- prevDigit: previous digit placed
- increasing: whether all digits so far are strictly increasing
- decreasing: whether all digits so far are strictly decreasing
- started: whether we've placed a non-zero digit yet

Since digit sum ≤ 135, prevDigit ≤ 9, pos ≤ 16, this is manageable.

## Complexity

- **Time:** O(16 * 2 * 136 * 10 * 2 * 2 * 2 * 10) = O(16 * 2 * 136 * 10 * 8 * 10) ≈ 3.5M states
- **Space:** Same
