# 2125. Number of Laser Beams in a Bank

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

## Problem

Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array `bank` representing the floor plan of the bank, which is an `m x n` 2D matrix. `bank[i]` represents the ith row, consisting of `'0'`s and `'1'`s. `'0'` means the cell is empty, while `'1'` means the cell has a security device.

There is one laser beam between any two security devices if both conditions are met:

- The two devices are located on two different rows: `r1` and `r2`, where `r1 < r2`.
- For each row `i` where `r1 < i < r2`, there are no security devices in the ith row.

Laser beams are independent, i.e., one beam does not interfere nor join with another.

Return the total number of laser beams in the bank.

## Examples

**Example 1:**
```
Input: bank = ["011001","000000","010100","001000"]
Output: 8
Explanation: Row 0 has 3 devices, row 2 has 2 devices (row 1 is empty, skipped), row 3 has 1 device.
Beams: 3*2 + 2*1 = 8.
```

**Example 2:**
```
Input: bank = ["000","111","000"]
Output: 0
Explanation: There are no two rows both containing devices without an empty row between them.
(Actually row 1 is the only non-empty row, so there's no pair of rows, giving 0.)
```

## Constraints

- `m == bank.length`
- `n == bank[i].length`
- `1 <= m, n <= 500`
- `bank[i][j]` is either `'0'` or `'1'`.
