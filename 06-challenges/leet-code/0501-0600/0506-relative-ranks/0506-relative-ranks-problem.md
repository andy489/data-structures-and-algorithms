# 506. Relative Ranks

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/relative-ranks/

---

## Problem Statement

You are given an integer array `score` of size `n`, where `score[i]` is the score of the `i`th athlete in a competition.

All the scores are guaranteed to be **unique**.

The athletes are **placed** based on their scores, where the `1st` place athlete has the highest score, the `2nd` place athlete has the second highest score, and so on.

Return an array `answer` of size `n` where `answer[i]` is the **rank** of the `i`th athlete:
- `"Gold Medal"` for the 1st place
- `"Silver Medal"` for the 2nd place
- `"Bronze Medal"` for the 3rd place
- For 4th to nth place, return their rank as a string.

---

## Examples

**Example 1:**
```
Input:  score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
```

**Example 2:**
```
Input:  score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
```

---

## Constraints

- `n == score.length`
- `1 <= n <= 10^4`
- `0 <= score[i] <= 10^6`
- All the values in `score` are unique.
