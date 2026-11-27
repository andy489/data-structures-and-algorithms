# 1203. Sort Items by Groups Respecting Dependencies

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/

---

## Problem Statement

There are `n` items each belonging to zero or one of `m` groups where `group[i]` is the group that the `i`-th item belongs to and it's equal to `-1` if the `i`-th item belongs to no group. The items and the groups are zero indexed. A group can have no item belonging to it.

Return a sorted list of the items such that:
- The items that belong to the same group are next to each other in the sorted list.
- There are some relations between these items expressed in a list `beforeItems`, where `beforeItems[i]` is a list containing all the items that should come before the `i`-th item in the sorted array (to the left of the `i`-th item).

Return any solution if there is more than one solution and return an empty list if there is no solution.

---

## Examples

**Example 1:**
```
Input:  n=8, m=2, group=[-1,-1,1,0,0,1,0,-1], beforeItems=[[],[6],[5],[6],[3,6],[],[],[]], Output: [6,3,4,1,5,2,0,7]
```

---

## Constraints

- `1 <= m <= n <= 3*10^4`
- `group.length == beforeItems.length == n`
- `-1 <= group[i] <= m-1`
- `0 <= beforeItems[i][j] <= n-1`
