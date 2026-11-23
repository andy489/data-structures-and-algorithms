# 401. Binary Watch

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-watch/

---

## Problem Statement

A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

Given an integer `turnedOn` which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

The hour must not contain a leading zero. The minute must consist of two digits and may contain a leading zero.

---

## Examples

**Example 1:**
```
Input:  turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
```

**Example 2:**
```
Input:  turnedOn = 9
Output: []
```

---

## Constraints

- `0 <= turnedOn <= 10`
