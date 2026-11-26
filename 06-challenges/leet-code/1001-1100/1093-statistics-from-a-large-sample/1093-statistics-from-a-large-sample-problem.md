# 1093. Statistics from a Large Sample

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/statistics-from-a-large-sample/

---

## Problem Statement

You are given a large sample of integers in the range `[0, 255]`. Since the sample is so large, it is represented by an array `count` where `count[i]` is the number of times that `i` appears in the sample.

Calculate the following statistics: minimum, maximum, mean, median, and mode. Return them as an array of doubles `[minimum, maximum, mean, median, mode]`.

---

## Examples

**Example 1:**
```
Input:  count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
Output: [1.0, 3.0, 2.375, 2.5, 3.0]
```

---

## Constraints

- `count.length == 256`
- `0 <= count[i] <= 10^9`
- `1 <= sum(count) <= 10^9`
- The mode is unique.
