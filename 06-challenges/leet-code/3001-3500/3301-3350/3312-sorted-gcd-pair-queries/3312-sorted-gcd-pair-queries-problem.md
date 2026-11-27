# 3312. Sorted GCD Pair Queries

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/sorted-gcd-pair-queries/

## Problem

You are given an integer array `nums` of length `n` and an integer array `queries`.

Let `gcdPairs` denote an array obtained by calculating the GCD of all possible pairs `(nums[i], nums[j])`, where `0 <= i < j < n`, and then sorting these values in **ascending** order.

For each query `queries[i]`, you need to find the element at index `queries[i]` in `gcdPairs`.

Return an integer array `answer`, where `answer[i]` is the value at `gcdPairs[queries[i]]` for each query.

## Examples

**Example 1:**
```
Input: nums = [2,3,4], queries = [0,2,2]
Output: [1,2,2]
Explanation: gcdPairs = [gcd(2,3), gcd(2,4), gcd(3,4)] = [1,2,1], sorted = [1,1,2].
```

**Example 2:**
```
Input: nums = [4,4,2,1], queries = [5,3,1,0]
Output: [4,2,1,1]
Explanation: gcdPairs sorted = [1,1,1,2,2,4].
```

**Example 3:**
```
Input: nums = [2,2], queries = [0,0]
Output: [2,2]
```

## Constraints

- `2 <= n == nums.length <= 10^5`
- `1 <= nums[i] <= 5 * 10^4`
- `1 <= queries.length <= 10^5`
- `0 <= queries[i] < n * (n - 1) / 2`
