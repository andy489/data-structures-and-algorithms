# 2028. Find Missing Observations

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-missing-observations/

---

## Problem Statement

You have made `m + n` observations of a 6-sided die. You have results for `m` rolls in `rolls`. Calculate the remaining `n` rolls such that the **mean** of all `m + n` rolls equals `mean`. Return the `n` rolls, or empty array if impossible.

---

## Examples

**Example 1:**
```
Input:  rolls = [3,2,4,3], mean = 4, n = 2
Output: [6,6]
```

**Example 2:**
```
Input:  rolls = [1,5,6], mean = 3, n = 4
Output: [2,3,2,2]
```

**Example 3:**
```
Input:  rolls = [1,2,3,4], mean = 6, n = 1
Output: []
```

---

## Constraints

- `m == rolls.length`
- `1 <= n, m <= 10^5`
- `1 <= rolls[i], mean <= 6`
