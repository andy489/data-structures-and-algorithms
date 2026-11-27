# 553. Optimal Division

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/optimal-division/

---

## Problem Statement

You are given an integer array `nums`. The adjacent integers in `nums` will perform the float division.

- For example, for `nums = [2,3,4]`, we will evaluate the expression `"2/3/4"`.

However, you can add any number of parentheses at any positions to change the priority of operations. You want to **maximize** the result of the expression.

Return the corresponding expression in string format.

**Note:** your expression should not contain redundant parentheses.

---

## Examples

**Example 1:**
```
Input:  nums = [1000,100,10,2]
Output: "1000/(100/10/2)"
Explanation: 1000/(100/10/2) = 1000/((100/10)/2) = 200; without any parentheses 1000/100/10/2 = 0.5
```

**Example 2:**
```
Input:  nums = [2,3,4]
Output: "2/(3/4)"
```

**Example 3:**
```
Input:  nums = [2]
Output: "2"
```

---

## Constraints

- `1 <= nums.length <= 10`
- `2 <= nums[i] <= 1000`
- There is only one optimal division for each test case
