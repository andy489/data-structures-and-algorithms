# 2092. Find All People With Secret

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-all-people-with-secret/

---

## Problem Statement

You have `n` people (0-indexed). Person 0 knows a secret. `meetings[i] = [xi, yi, timei]` means xi and yi meet at time timei. The secret spreads instantly among all connected people at the same time. Return the list of all people who know the secret after all meetings.

---

## Examples

**Example 1:**
```
Input:  n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
Output: [0,1,2,3,5]
```

**Example 2:**
```
Input:  n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
Output: [0,1,3]
```

**Example 3:**
```
Input:  n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
Output: [0,1,2,3,4]
```

---

## Constraints

- `2 <= n <= 10^5`
- `1 <= meetings.length <= 10^5`
- `meetings[i].length == 3`
- `0 <= firstPerson < n`
