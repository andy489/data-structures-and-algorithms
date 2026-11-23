# 575. Distribute Candies

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/distribute-candies/

---

## Problem Statement

Alice has `n` candies, where the `i`th candy is of type `candyType[i]`. Alice noticed that she started to gain weight, so she visited a doctor.

The doctor advised Alice to only eat `n / 2` of the `n` candies she has (`n` is always even). Alice likes her candies very much, and she wants to eat the maximum number of **different types** of candies while still following the doctor's advice.

Given the integer array `candyType` of length `n`, return *the **maximum** number of different types of candies she can eat if she only eats* `n / 2` *of them*.

---

## Examples

**Example 1:**
```
Input:  candyType = [1,1,2,2,3,3]
Output: 3
```

**Example 2:**
```
Input:  candyType = [1,1,2,3]
Output: 2
```

**Example 3:**
```
Input:  candyType = [6,6,6,6]
Output: 1
```

---

## Constraints

- `n == candyType.length`
- `2 <= n <= 10^4`
- `n` is even
- `-10^5 <= candyType[i] <= 10^5`
