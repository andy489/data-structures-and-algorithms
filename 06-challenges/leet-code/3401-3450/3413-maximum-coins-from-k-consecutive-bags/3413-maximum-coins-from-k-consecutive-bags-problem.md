# 3413. Maximum Coins From K Consecutive Bags

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-coins-from-k-consecutive-bags/

## Problem

There are bags on a number line. coins[i] = [li, ri, ci] means bags from li to ri each have ci coins. The segments are non-overlapping.

Return the maximum number of coins you can collect from k consecutive bags.

## Examples

**Example 1:**

Input: coins = [[8,10,1],[1,3,2],[5,6,4]], k = 4
Output: 10

Explanation: Bags at [3,4,5,6] give 2+0+4+4=10.

**Example 2:**

Input: coins = [[1,10,3]], k = 2
Output: 6

## Constraints

- 1 <= coins.length <= 10^5
- 1 <= k <= 10^9
- 1 <= li <= ri <= 10^9
- 1 <= ci <= 1000
- Segments are non-overlapping.
