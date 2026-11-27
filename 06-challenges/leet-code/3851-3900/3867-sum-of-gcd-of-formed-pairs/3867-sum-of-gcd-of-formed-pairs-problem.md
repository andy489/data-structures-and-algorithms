# 3867. Sum of GCD of Formed Pairs

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/

## Problem

You are given an integer array `nums` of length `n`.

Construct an array `prefixGcd` where for each index `i`:
- Let `mxi = max(nums[0], nums[1], ..., nums[i])`.
- `prefixGcd[i] = gcd(nums[i], mxi)`.

After constructing `prefixGcd`:
- Sort `prefixGcd` in non-decreasing order.
- Form pairs by taking the smallest unpaired element and the largest unpaired element.
- Repeat until no more pairs can be formed.
- For each formed pair, compute the gcd of the two elements.
- If `n` is odd, the middle element remains unpaired and is ignored.

Return an integer denoting the sum of the GCD values of all formed pairs.

## Examples

**Example 1:**
```
Input: nums = [2,6,4]
Output: 2
Explanation: prefixGcd = [2, 6, 2]. Sorted: [2, 2, 6]. Pair (2, 6): gcd = 2. Middle 2 ignored. Sum = 2.
```

**Example 2:**
```
Input: nums = [3,6,2,8]
Output: 5
Explanation: prefixGcd = [3, 6, 2, 8]. Sorted: [2, 3, 6, 8]. Pairs: gcd(2,8)=2, gcd(3,6)=3. Sum = 5.
```

## Constraints

- `1 <= n == nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
