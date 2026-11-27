# 599. Minimum Index Sum of Two Lists

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-index-sum-of-two-lists/

---

## Problem Statement

Given two arrays of strings `list1` and `list2`, find the **common strings with the least index sum**.

A common string is a string that appeared in both `list1` and `list2`. A common string with the **least index sum** is a common string such that if it appeared at `list1[i]` and `list2[j]`, then `i + j` should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in **any order**.

---

## Examples

**Example 1:**
```
Input:  list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
        list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
```

**Example 2:**
```
Input:  list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
        list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
```

**Example 3:**
```
Input:  list1 = ["happy","sad","good"],
        list2 = ["sad","happy","good"]
Output: ["sad","happy"]
```

---

## Constraints

- `1 <= list1.length, list2.length <= 1000`
- `1 <= list1[i].length, list2[i].length <= 30`
- `list1[i]` and `list2[i]` consist of lowercase and uppercase English letters and spaces.
- All the strings of `list1` are **unique**.
- All the strings of `list2` are **unique**.
- There is at least a common string between `list1` and `list2`.
