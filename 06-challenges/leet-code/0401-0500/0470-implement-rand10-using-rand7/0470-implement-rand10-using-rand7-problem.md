# 470. Implement Rand10() Using Rand7()

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/implement-rand10-using-rand7/

---

## Problem Statement

Given the **API** `rand7()` that generates a uniform random integer in the range `[1, 7]`, write a function `rand10()` that generates a uniform random integer in the range `[1, 10]`.

You can only call the API `rand7()`, and you should not use any other API. Please do not use a system's `Math.random()` or `random()` to solve this problem.

Each test case will have one **internal** argument `n`, the number of times that your implemented function `rand10()` will be called while testing. Note that this is **not an argument** passed to `rand10()`.

---

## Examples

**Example 1:**
```
Input:  n = 1
Output: [2]
```

**Example 2:**
```
Input:  n = 2
Output: [2, 8]
```

**Example 3:**
```
Input:  n = 3
Output: [3, 8, 10]
```

---

## Constraints

- `1 <= n <= 10^5`
