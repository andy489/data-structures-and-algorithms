# 1722. Minimize Hamming Distance After Swap Operations

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/

---

## Problem Statement

You are given two integer arrays, `source` and `target`, both of length `n`. You are also given an array `allowedSwaps` where each `allowedSwaps[i] = [ai, bi]` indicates that you are allowed to swap the elements at index `ai` and index `bi` of array `source`. Note that you can swap elements at a specific pair of indices **multiple** times and in **any** order.

The **Hamming distance** of two arrays of the same length, `source` and `target`, is the number of positions where the elements are different.

Return *the **minimum Hamming distance** of* `source` *and* `target` *after performing **any** amount of swap operations on array* `source`.

---

## Examples

**Example 1:**
```
Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
Output: 1
Explanation: source[0] and source[1] can be swapped => [2,1,3,4] or [1,2,3,4].
source[2] and source[3] can be swapped => [2,1,4,3].
Minimum distance = 1 (position 3: 3 != 5).
```

**Example 2:**
```
Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
Output: 2
```

---

## Constraints

- `n == source.length == target.length`
- `1 <= n <= 10^5`
- `0 <= source[i], target[i] <= 10^5`
- `0 <= allowedSwaps.length <= 10^5`
- `allowedSwaps[i].length == 2`
- `0 <= ai, bi <= n - 1`
- `ai != bi`
