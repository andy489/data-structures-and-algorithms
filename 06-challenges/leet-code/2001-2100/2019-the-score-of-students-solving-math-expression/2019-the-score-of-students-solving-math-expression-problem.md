# 2019. The Score of Students Solving Math Expression

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/the-score-of-students-solving-math-expression/

---

## Problem Statement

You are given a string `s` which contains digits `0-9` and `+` and `*`. Students evaluate the expression and you are given `answers`. Award 5 points for the correct answer, 2 points for a possible answer from wrong-order evaluation, 0 otherwise. Return total points.

---

## Examples

**Example 1:**
```
Input:  s = "7+3*1*2", answers = [20,13,42]
Output: 7
```
Explanation: Correct=13(5pts), 20 is reachable(2pts), 42 not(0pts).

**Example 2:**
```
Input:  s = "3+5*2", answers = [13,0,10,13,13,16,16]
Output: 19
```

---

## Constraints

- `3 <= s.length <= 31`
- `s represents a valid expression.`
- `s consists of digits and '+' and '*'.`
- `All the operand values are in [0, 9].`
- `1 <= answers.length <= 10^4`
- `0 <= answers[i] <= 1000`
