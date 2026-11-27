# 319. Bulb Switcher

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bulb-switcher/

---

## Problem Statement

There are `n` bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb, then you turn on every third bulb, and so on.

More precisely, in the `i`th round (1-indexed), you toggle every `i`th bulb. After `n` rounds, return the number of bulbs that are on.

---

## Examples

**Example 1:**
```
Input:  n = 3
Output: 1
Explanation: At first, the three bulbs are [off, off, off].
After the first round, the three bulbs are [on, on, on].
After the second round, the three bulbs are [on, off, on].
After the third round, the three bulbs are [on, off, off].
So you should return 1 because there is only one bulb on.
```

**Example 2:**
```
Input:  n = 0
Output: 0
```

**Example 3:**
```
Input:  n = 1
Output: 1
```

---

## Constraints

- `0 <= n <= 10^9`
