# 1282. Group the People Given the Group Size They Belong To

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

---

## Problem Statement

There are `n` people whose IDs go from `0` to `n - 1` and each person belongs exactly to one group. Given the array `groupSizes` of length `n` telling the group size each person belongs to, return the groups there are and the people's IDs each group includes.

You can return any solution, and it is guaranteed an answer exists.

---

## Examples

**Example 1:**
```
Input:  groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
```

---

## Constraints

- `groupSizes.length == n`
- `1 <= n <= 500`
- `1 <= groupSizes[i] <= n`
