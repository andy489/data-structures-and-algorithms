# 898. Bitwise ORs of Subarrays

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bitwise-ors-of-subarrays/

---

## Problem Statement

Given an integer array `arr`, return the number of distinct values of bitwise ORs of all the non-empty subarrays of `arr`.

The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of the subarray `arr[i...j]` is `arr[i] | arr[i + 1] | ... | arr[j]`.

---

## Examples

**Example 1:**
```
Input:  arr = [0]
Output: 1
Explanation: There is only one possible result: 0.
```

**Example 2:**
```
Input:  arr = [1,1,2]
Output: 3
Explanation: The possible subarrays are [1], [1], [2], [1,1], [1,2], [1,1,2].
The resulting values are 1, 1, 2, 1, 3, 3.
After deduplication, 1, 2, 3.
```

**Example 3:**
```
Input:  arr = [1,2,4]
Output: 6
Explanation: The possible results are 1, 2, 3, 4, 6, 7.
```

---

## Constraints

- `1 <= arr.length <= 5 * 10^4`
- `0 <= arr[i] <= 10^9`
