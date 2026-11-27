# 3917. Count Indices With Opposite Parity

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/count-indices-with-opposite-parity/

## Problem

You are given an integer array `nums` of length `n`.

The **score** of an index `i` is defined as the number of indices `j` such that:
- `i < j < n`, and
- `nums[i]` and `nums[j]` have different parity (one is even and the other is odd).

Return an integer array `answer` of length `n`, where `answer[i]` is the score of index `i`.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4]
Output: [2,1,1,0]

Explanation:
- nums[0]=1 (odd): j=1 (even) and j=3 (even) -> score 2.
- nums[1]=2 (even): j=2 (odd) -> score 1.
- nums[2]=3 (odd): j=3 (even) -> score 1.
- nums[3]=4 (even): no valid j -> score 0.
```

**Example 2:**
```
Input: nums = [1]
Output: [0]
```

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
