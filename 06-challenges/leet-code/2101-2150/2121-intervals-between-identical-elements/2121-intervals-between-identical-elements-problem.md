# 2121. Intervals Between Identical Elements

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/intervals-between-identical-elements/

## Problem

You are given a 0-indexed array of `n` integers `arr`.

The interval between two elements in `arr` is defined as the absolute difference between their indices. More formally, the interval between `arr[i]` and `arr[j]` is `|i - j|`.

Return an array `intervals` of length `n` where `intervals[i]` is the sum of intervals between `arr[i]` and each element in `arr` with the same value as `arr[i]`.

**Note:** `|x|` is the absolute value of `x`.

## Examples

**Example 1:**
```
Input: arr = [2,1,3,1,2,3,3]
Output: [4,2,7,2,4,4,5]
Explanation:
- Index 0: Another 2 at index 4. |0-4| = 4
- Index 1: Another 1 at index 3. |1-3| = 2
- Index 2: 3s at indices 5 and 6. |2-5|+|2-6| = 7
- Index 3: Another 1 at index 1. |3-1| = 2
- Index 4: Another 2 at index 0. |4-0| = 4
- Index 5: 3s at indices 2 and 6. |5-2|+|5-6| = 4
- Index 6: 3s at indices 2 and 5. |6-2|+|6-5| = 5
```

**Example 2:**
```
Input: arr = [10,5,10,10]
Output: [5,0,3,4]
```

## Constraints

- `n == arr.length`
- `1 <= n <= 10^5`
- `1 <= arr[i] <= 10^5`
