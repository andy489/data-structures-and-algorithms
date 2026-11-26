# 477. Total Hamming Distance

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/total-hamming-distance/

---

## Problem Statement

The [Hamming distance](https://en.wikipedia.org/wiki/Hamming_distance) between two integers is the number of positions at which the corresponding bits are different.

Given an integer array `nums`, return *the sum of **Hamming distances** between all the pairs of the integers in* `nums`.

---

## Examples

**Example 1:**
```
Input:  nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010.
The answer will be: HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
```

**Example 2:**
```
Input:  nums = [4,14,4]
Output: 4
```

---

## Constraints

- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 10^9`
