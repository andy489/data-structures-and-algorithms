# 2024. Maximize the Confusion of an Exam

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

---

## Problem Statement

A teacher is writing an exam of T/F questions. `answerKey` is a string of 'T' and 'F'. In one operation, change any answer. Find the maximum number of consecutive same answers after at most `k` operations.

---

## Examples

**Example 1:**
```
Input:  answerKey = "TTFF", k = 2
Output: 4
```
Explanation: Change both F to T.

**Example 2:**
```
Input:  answerKey = "TFFT", k = 1
Output: 3
```

**Example 3:**
```
Input:  answerKey = "TTFTTFTT", k = 1
Output: 5
```

---

## Constraints

- `n == answerKey.length`
- `1 <= n <= 5 * 10^4`
- `answerKey[i] is 'T' or 'F'`
- `1 <= k <= n`
