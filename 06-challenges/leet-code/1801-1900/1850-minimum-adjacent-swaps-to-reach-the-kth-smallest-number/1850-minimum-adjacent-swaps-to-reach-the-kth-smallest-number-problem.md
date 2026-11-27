# 1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/

---

## Problem Statement

You are given a string `num`, representing a large integer, and an integer `k`.

We call some integer **wonderful** if it is a **permutation** of the digits in `num` and is **greater in value** than `num`. There can be many wonderful integers. Only the **smallest-valued** wonderful integers are considered **wonderful**.

- There are at least two wonderful integers. Only the **smallest** `k` wonderful integers are **considered wonderful**.

Return *the* **minimum number of adjacent digit swaps** that needs to be applied to `num` to reach the* `k`th *wonderful integer.*

---

## Examples

**Example 1:**
```
Input: num = "5489355142", k = 4
Output: 2
```

**Example 2:**
```
Input: num = "11112", k = 4
Output: 4
```

**Example 3:**
```
Input: num = "00123", k = 1
Output: 1
```

---

## Constraints

- `2 <= num.length <= 1000`
- `1 <= k <= 1000`
- `num` only consists of digits.
