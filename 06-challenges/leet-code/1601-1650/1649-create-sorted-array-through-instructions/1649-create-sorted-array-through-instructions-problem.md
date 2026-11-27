# 1649. Create Sorted Array Through Instructions

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/create-sorted-array-through-instructions/

---

## Problem Statement

Given an integer array `instructions`, you are asked to create a sorted array from the elements in `instructions`. You start with an empty container `nums`. For each element from **left to right** in `instructions`, insert it into `nums`. The **cost** of each insertion is the **minimum** of:
- The number of elements currently in `nums` that are **strictly less than** `instructions[i]`.
- The number of elements currently in `nums` that are **strictly greater than** `instructions[i]`.

Return the **total cost** to insert all elements from `instructions` into `nums`. Since the answer may be large, return it modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input: instructions = [1,5,6,2]
Output: 1
Explanation:
- Insert 1: cost min(0,0)=0
- Insert 5: cost min(1,0)=0
- Insert 6: cost min(2,0)=0
- Insert 2: cost min(1,2)=1
Total = 1
```

**Example 2:**
```
Input: instructions = [1,2,3,6,5,4]
Output: 3
```

**Example 3:**
```
Input: instructions = [1,3,3,3,2,4,2,1,2]
Output: 4
```

---

## Constraints

- `1 <= instructions.length <= 10^5`
- `1 <= instructions[i] <= 10^5`
