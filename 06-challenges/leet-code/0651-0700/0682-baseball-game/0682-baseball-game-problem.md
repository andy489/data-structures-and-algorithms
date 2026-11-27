# 682. Baseball Game

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/baseball-game/

---

## Problem Statement

You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.

You are given a list of strings `operations`, where `operations[i]` is the `i`th operation you must apply to the record and is one of the following:

- An integer `x` — record a new score of `x`.
- `"+"` — record a new score that is the sum of the previous two scores.
- `"D"` — record a new score that is the double of the previous score.
- `"C"` — invalidate the previous score, removing it from the record.

Return the sum of all the scores on the record after applying all the operations.

---

## Examples

**Example 1:**
```
Input:  ops = ["5","2","C","D","+"]
Output: 30
```

**Example 2:**
```
Input:  ops = ["5","-2","4","C","D","9","+","+"]
Output: 27
```

---

## Constraints

- `1 <= operations.length <= 1000`
- `operations[i]` is `"C"`, `"D"`, `"+"`, or a string representing an integer in the range `[-3 * 10⁴, 3 * 10⁴]`.
- For operation `"+"`, there will always be at least two previous scores on the record.
- For operations `"C"` and `"D"`, there will always be at least one previous score on the record.
