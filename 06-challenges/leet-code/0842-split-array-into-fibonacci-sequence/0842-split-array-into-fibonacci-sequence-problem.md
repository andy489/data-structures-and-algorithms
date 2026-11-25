# 842. Split Array into Fibonacci Sequence

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/split-array-into-fibonacci-sequence/

---

## Problem Statement

You are given a string of digits `num`. Return any Fibonacci-like sequence split from `num`, or return `[]` if it cannot be done. A Fibonacci-like sequence has each element equal to the sum of the two preceding ones (at least 3 elements).

Numbers with leading zeros are not allowed (except the number 0 itself).

---

## Examples

**Example 1:**
```
Input:  num = "1101111"
Output: [11,0,11,11]
```

**Example 2:**
```
Input:  num = "112358130"
Output: []
```

---

## Constraints

- `1 <= num.length <= 200`
- `num` contains only digits.
