# 1962. Remove Stones to Minimize the Total

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-stones-to-minimize-the-total/

## Description

You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:

- Choose any piles[i] and remove floor(piles[i] / 2) stones from it.

Notice that you can apply the operation on the same pile more than once.

Return the minimum possible total number of stones remaining after applying the k operations.

floor(x) is the largest integer that is smaller than or equal to x (i.e., rounds x down).

## Examples

**Example 1:**
```
Input: piles = [5,4,9], k = 2
Output: 12
```

**Example 2:**
```
Input: piles = [4,3,6,7], k = 3
Output: 12
```

## Constraints

- 1 <= piles.length <= 10^5
- 1 <= piles[i] <= 10^4
- 1 <= k <= 10^5
