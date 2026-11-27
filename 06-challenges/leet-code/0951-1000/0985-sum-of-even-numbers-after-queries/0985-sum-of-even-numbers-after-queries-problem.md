# 985. Sum of Even Numbers After Queries

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-even-numbers-after-queries/

---

## Problem Statement

You are given an integer array `nums` and an array `queries` where `queries[i] = [val, index]`.

For each query `i`, first, apply `nums[index] += val`, then print the sum of the even values of `nums`.

Return an integer array `answer` where `answer[i]` is the answer to the `i`th query.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
```

---

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `1 <= queries.length <= 10^4`
- `-10^4 <= queries[i][0] <= 10^4`
- `0 <= queries[i][1] < nums.length`
