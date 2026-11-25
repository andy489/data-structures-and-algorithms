# 1013. Partition Array Into Three Parts With Equal Sum

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/

---

## Problem Statement

Given an array of integers `arr`, return `true` if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes `i + 1 < j` with `(arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])`.

---

## Examples

**Example 1:**
```
Input:  arr = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
```

**Example 2:**
```
Input:  arr = [3,3,6,5,-2,2,5,1,-9,4]
Output: false
```

---

## Constraints

- `3 <= arr.length <= 5 * 10^4`
- `-10^4 <= arr[i] <= 10^4`
