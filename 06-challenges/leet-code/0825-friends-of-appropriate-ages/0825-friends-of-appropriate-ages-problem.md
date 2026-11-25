# 825. Friends Of Appropriate Ages

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/friends-of-appropriate-ages/

---

## Problem Statement

There are `n` persons on a social media website. You are given an integer array `ages` where `ages[i]` is the age of the `i`th person. Person `A` will NOT friend request person `B` if any of the following conditions is true:

- `age[B] <= 0.5 * age[A] + 7`
- `age[B] > age[A]`
- `age[B] > 100 && age[A] < 100`

Return the total number of friend requests made.

---

## Examples

**Example 1:**
```
Input:  ages = [16,16]
Output: 2
```

**Example 2:**
```
Input:  ages = [16,17,18]
Output: 2
```

---

## Constraints

- `n == ages.length`
- `1 <= n <= 2 * 10^4`
- `1 <= ages[i] <= 120`
