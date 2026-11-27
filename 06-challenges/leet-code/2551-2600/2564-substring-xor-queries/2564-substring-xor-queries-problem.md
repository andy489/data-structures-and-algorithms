# 2564. Substring XOR Queries

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/substring-xor-queries/

---

## Problem Statement

You are given a **binary string** `s`, and a **2D** integer array `queries` where `queries[i] = [first_i, second_i]`.

For the `i`th query, find the **shortest substring** of `s` whose **decimal value**, `val`, yields `second_i` when **bitwise XORed** with `first_i`. In other words, `val ^ first_i == second_i`.

The answer to the `i`th query is the endpoints (**0-indexed**) of the substring `[left_i, right_i]` or `[-1, -1]` if no such substring exists. If there are multiple answers, choose the one with the **minimum** `left_i`.

Return an array `ans` where `ans[i] = [left_i, right_i]` is the answer to the `i`th query.

A **substring** is a contiguous non-empty sequence of characters within a string.

---

## Examples

**Example 1:**
```
Input:  s = "101101", queries = [[0,5],[1,2]]
Output: [[0,2],[2,3]]
```
*Explanation:* For query [0,5]: substring "101" has value 5, and 5 ^ 0 = 5. For query [1,2]: substring "11" has value 3, and 3 ^ 1 = 2.

**Example 2:**
```
Input:  s = "0101", queries = [[12,8]]
Output: [[-1,-1]]
```
*Explanation:* In this example, there is no substring that answers the query.

---

## Constraints

- `1 <= s.length <= 10^4`
- `s[i]` is either `'0'` or `'1'`.
- `1 <= queries.length <= 10^5`
- `0 <= first_i, second_i <= 10^9`
