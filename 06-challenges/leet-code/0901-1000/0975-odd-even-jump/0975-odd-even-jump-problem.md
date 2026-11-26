# 975. Odd Even Jump

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/odd-even-jump/

---

## Problem Statement

You are given an integer array `arr`. From some starting index, you can make a series of jumps. The (1st, 3rd, 5th, ...) jumps are called odd-numbered jumps, and the (2nd, 4th, 6th, ...) jumps are called even-numbered jumps.

For an odd-numbered jump (like jump 1, 3, 5, ...): You jump to the smallest element in `arr[j]` where `j > i` and `arr[j] >= arr[i]`. If multiple such indices exist, take the smallest such index.

For an even-numbered jump (like jump 2, 4, 6, ...): You jump to the largest element in `arr[j]` where `j > i` and `arr[j] <= arr[i]`. If multiple such such indices exist, take the smallest such index.

Return the number of good starting indices where you can reach the end of the array.

---

## Examples

**Example 1:**
```
Input:  arr = [10,13,12,14,15]
Output: 2
```

**Example 2:**
```
Input:  arr = [2,3,1,1,4]
Output: 3
```

---

## Constraints

- `1 <= arr.length <= 2 * 10^4`
- `0 <= arr[i] < 10^5`
