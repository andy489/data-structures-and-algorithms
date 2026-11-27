# 3361. Shift Distance Between Two Strings

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shift-distance-between-two-strings/

---

## Problem Statement

You are given two strings `s` and `t` of the same length, and two integer arrays `nextCost` and `previousCost`.

In one operation, you can pick any index `i` of `s`, and perform **either one** of the following actions:

- Shift `s[i]` to the next letter in the alphabet. If `s[i] == 'z'`, you should replace it with `'a'`. This operation costs `nextCost[j]` where `j` is the index of `s[i]` in the alphabet.
- Shift `s[i]` to the previous letter in the alphabet. If `s[i] == 'a'`, you should replace it with `'z'`. This operation costs `previousCost[j]` where `j` is the index of `s[i]` in the alphabet.

The **shift distance** is the **minimum** total cost of operations required to transform `s` into `t`.

Return the **shift distance** from `s` to `t`.

---

## Examples

**Example 1:**
```
Input:  s = "abab", t = "baba",
        nextCost = [100,0,...], previousCost = [1,100,0,...]
Output: 2
```
Shifting 'a'→'b' forward costs 100 each, but shifting backward 25 steps costs 1 each.

**Example 2:**
```
Input:  s = "leet", t = "code",
        nextCost = [1,1,...,1], previousCost = [1,1,...,1]
Output: 31
```
Each step costs 1; choose the shorter direction for each character pair.

---

## Constraints

- `1 <= s.length == t.length <= 10^5`
- `s` and `t` consist only of lowercase English letters.
- `nextCost.length == previousCost.length == 26`
- `0 <= nextCost[i], previousCost[i] <= 10^9`
