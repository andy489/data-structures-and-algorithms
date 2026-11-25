# 936. Stamping the Sequence

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stamping-the-sequence/

---

## Problem Statement

You want to form a `target` string of **lowercase letters**.

At the beginning, your sequence is `target.length` `'?'` characters. In each turn, you may place `stamp` over the sequence, replacing `stamp.length` characters with `stamp`. Return an array of the index of the left-most letter being stamped at each turn, or return an empty array if it is impossible to stamp the target.

Each turn, you must stamp over at least one non-`'?'` character. The number of turns may not exceed `10 * target.length`.

---

## Examples

**Example 1:**
```
Input:  stamp = "abc", target = "ababc"
Output: [0,2]
```

---

## Constraints

- `1 <= stamp.length <= target.length <= 1000`
- `stamp` and `target` consist of lowercase English letters.
