# 672. Bulb Switcher II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bulb-switcher-ii/

---

## Problem Statement

There is a room with `n` bulbs labeled from `1` to `n`. They are arranged in a row, and each bulb has its own switch. Initially, all the bulbs are turned on.

At moment zero, all the bulbs are turned on. Then, there are four buttons, each does the following:

- **Button 1**: Flips the status of all the bulbs.
- **Button 2**: Flips the status of all the bulbs with even labels (i.e., label % 2 == 0).
- **Button 3**: Flips the status of all the bulbs with odd labels (i.e., label % 2 == 1).
- **Button 4**: Flips the status of all the bulbs with labels where `label % 3 == 0`.

Given two integers `n` and `presses`, return the number of **different possible statuses** after performing all presses.

---

## Examples

**Example 1:**
```
Input:  n = 1, presses = 1
Output: 2
```

**Example 2:**
```
Input:  n = 2, presses = 1
Output: 3
```

**Example 3:**
```
Input:  n = 3, presses = 1
Output: 4
```

---

## Constraints

- `1 <= n <= 1000`
- `0 <= presses <= 1000`
