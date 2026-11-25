# 952. Largest Component Size by Common Factor

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/largest-component-size-by-common-factor/

---

## Problem Statement

You are given an integer array of unique positive integers `nums`. Consider the following graph:

- There are `nums.length` nodes, labeled `nums[0]` to `nums[nums.length - 1]`,
- There is an edge between `nums[i]` and `nums[j]` if `nums[i]` and `nums[j]` share a common factor greater than 1.

Return the size of the largest connected component in the graph.

---

## Examples

**Example 1:**
```
Input:  nums = [4,6,15,35]
Output: 4
```

**Example 2:**
```
Input:  nums = [20,50,9,63]
Output: 2
```

---

## Constraints

- `1 <= nums.length <= 2 * 10^4`
- `1 <= nums[i] <= 10^5`
- All the values of `nums` are unique.
