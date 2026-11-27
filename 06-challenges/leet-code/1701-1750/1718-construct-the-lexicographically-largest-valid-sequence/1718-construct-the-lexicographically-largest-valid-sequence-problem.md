# 1718. Construct the Lexicographically Largest Valid Sequence

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/

---

## Problem Statement

Given an integer `n`, find a sequence with elements in the range `[1, n]` that satisfies all of the following:

- The integer `1` occurs once in the sequence.
- Each integer between `2` and `n` occurs twice in the sequence.
- For every integer `i` between `2` and `n`, the **distance** between the two occurrences of `i` is exactly `i`.

The **distance** between two numbers on the sequence, `a[i]` and `a[j]`, is the absolute difference of their indices, `|j - i|`.

Return the **lexicographically largest** sequence. It is guaranteed that under the given constraints, there is always a solution.

---

## Examples

**Example 1:**
```
Input: n = 3
Output: [3,1,2,3,2]
```

**Example 2:**
```
Input: n = 5
Output: [5,3,1,4,3,5,2,4,2]
```

---

## Constraints

- `1 <= n <= 20`
