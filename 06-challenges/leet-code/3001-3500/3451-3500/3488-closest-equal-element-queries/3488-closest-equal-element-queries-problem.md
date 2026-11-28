# 3488. Closest Equal Element Queries

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/closest-equal-element-queries/

---

## Problem Statement

You are given a **circular** array `nums` and an array `queries`.

For each query `i`, you have to find the following:

- The **minimum** distance between the element at index `queries[i]` and **any** other index `j` in the **circular** array, where `nums[j] == nums[queries[i]]`. If no such index exists, the answer for that query should be -1.

Return an array `answer` of the **same** size as `queries`, where `answer[i]` represents the result for query `i`.

---

## Examples

**Example 1:**
```
Input: nums = [1,3,1,4,1,3,2], queries = [0,3,5]
Output: [2,-1,3]
Explanation:
- Query 0: nums[0]=1. Nearest other index with value 1 is 2, distance 2.
- Query 1: nums[3]=4. No other index has value 4, result -1.
- Query 2: nums[5]=3. Nearest is index 1, circular distance = min(4,3) = 3 (path: 5->6->0->1).
```

**Example 2:**
```
Input: nums = [1,2,3,4], queries = [0,1,2,3]
Output: [-1,-1,-1,-1]
```

---

## Constraints

- `1 <= queries.length <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^6`
- `0 <= queries[i] < nums.length`
