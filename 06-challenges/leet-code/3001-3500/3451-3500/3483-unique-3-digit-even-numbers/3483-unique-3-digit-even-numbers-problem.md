# 3483. Unique 3-Digit Even Numbers

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/unique-3-digit-even-numbers/

---

## Problem Statement

You are given an array of digits called `digits`. Your task is to determine the number of **distinct** three-digit even numbers that can be formed using these digits.

**Note**: Each copy of a digit can only be used **once per number**, and there may **not** be leading zeros.

---

## Examples

**Example 1:**
```
Input: digits = [1,2,3,4]
Output: 12
Explanation: The 12 distinct 3-digit even numbers are 124, 132, 134, 142, 214, 234, 312, 314, 324, 342, 412, and 432.
```

**Example 2:**
```
Input: digits = [0,2,2]
Output: 2
Explanation: The only 3-digit even numbers are 202 and 220.
```

**Example 3:**
```
Input: digits = [6,6,6]
Output: 1
Explanation: Only 666 can be formed.
```

**Example 4:**
```
Input: digits = [1,3,5]
Output: 0
```

---

## Constraints

- `3 <= digits.length <= 10`
- `0 <= digits[i] <= 9`
