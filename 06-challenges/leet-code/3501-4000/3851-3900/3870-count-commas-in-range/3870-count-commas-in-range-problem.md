# 3870. Count Commas in Range

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/count-commas-in-range/

## Problem

You are given an integer `n`.

Return the total number of commas used when writing all integers from `[1, n]` (inclusive) in standard number formatting.

In standard formatting:
- A comma is inserted after every three digits from the right.
- Numbers with fewer than 4 digits contain no commas.

## Examples

**Example 1:**
```
Input: n = 1002
Output: 3
Explanation: "1,000", "1,001", and "1,002" each contain one comma. Total = 3.
```

**Example 2:**
```
Input: n = 998
Output: 0
Explanation: All numbers from 1 to 998 have fewer than four digits. No commas.
```

## Constraints

- `1 <= n <= 10^5`
