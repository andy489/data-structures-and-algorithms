# 1010. Pairs of Songs With Total Durations Divisible by 60

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

---

## Problem Statement

You are given a list of songs where the `i`th song has a duration of `time[i]` seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by `60`. Formally, we want the number of indices `i`, `j` such that `i < j` with `(time[i] + time[j]) % 60 == 0`.

---

## Examples

**Example 1:**
```
Input:  time = [30,20,150,100,40]
Output: 3
```

**Example 2:**
```
Input:  time = [60,60,60]
Output: 3
```

---

## Constraints

- `1 <= time.length <= 6 * 10^4`
- `1 <= time[i] <= 500`
