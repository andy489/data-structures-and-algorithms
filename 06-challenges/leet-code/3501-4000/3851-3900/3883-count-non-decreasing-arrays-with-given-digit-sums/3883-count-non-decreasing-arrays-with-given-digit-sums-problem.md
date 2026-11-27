# 3883. Count Non-Decreasing Arrays With Given Digit Sums

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-non-decreasing-arrays-with-given-digit-sums/

## Problem

You are given an integer array `digitSum` of length `n`.

An array `arr` of length `n` is considered **valid** if:
- `0 <= arr[i] <= 5000`
- it is **non-decreasing**
- the **sum of the digits** of `arr[i]` equals `digitSum[i]`

Return an integer denoting the number of **distinct valid arrays**. Since the answer may be large, return it modulo `10^9 + 7`.

## Examples

**Example 1:**
```
Input: digitSum = [25,1]
Output: 6
Explanation:
Numbers with digit sum 25 in [0,5000]: 799, 889, 898, 979, 988, 997.
Only 1000 has digit sum 1 and >= each of these.
Valid arrays: [799,1000],[889,1000],[898,1000],[979,1000],[988,1000],[997,1000] -> 6.
```

**Example 2:**
```
Input: digitSum = [1]
Output: 4
Explanation: Valid arrays: [1],[10],[100],[1000].
```

**Example 3:**
```
Input: digitSum = [2,49,23]
Output: 0
Explanation: No integer in [0,5000] has digit sum 49.
```

## Constraints

- `1 <= digitSum.length <= 1000`
- `0 <= digitSum[i] <= 50`
