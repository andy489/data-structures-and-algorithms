# 619. Biggest Single Number

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/biggest-single-number/

---

## Problem Statement

Table `MyNumbers`:

```
+-------------+------+
| Column Name | Type |
+-------------+------+
| num         | int  |
+-------------+------+
```

This table may contain duplicates (In other words, there is no primary key for this table in SQL). Each row contains an integer.

A **single number** is a number that appeared only once in the `MyNumbers` table.

Find the **largest single number**. If there is no single number, report `null`.

---

## Examples

**Example 1:**
```
Input:
MyNumbers table: [8, 8, 3, 3, 1, 4, 5, 6]
Output: 6
```

**Example 2:**
```
Input:
MyNumbers table: [8, 8, 3, 3]
Output: null
```

---

## Constraints

- `1 <= MyNumbers.num <= 100`
- `1 <= MyNumbers.length <= 100`
