# 2959. Number of Possible Sets of Closing Branches

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-possible-sets-of-closing-branches/

## Problem

There is a company with `n` branches across the country, some of which are connected by roads. Initially, all branches are reachable from each other by traveling some roads.

The company has decided to close down some of these branches (possibly none). However, they want to ensure that the remaining branches have a distance of at most `maxDistance` from each other.

The distance between two branches is the minimum total traveled length needed to reach one branch from another.

You are given integers `n`, `maxDistance`, and a 0-indexed 2D array `roads`, where `roads[i] = [ui, vi, wi]` represents the undirected road between branches `ui` and `vi` with length `wi`.

Return the number of possible sets of closing branches, so that any branch has a distance of at most `maxDistance` from any other.

Note that, after closing a branch, the company will no longer have access to any roads connected to it.

Note that multiple roads are allowed.

## Examples

**Example 1:**
```
Input: n = 3, maxDistance = 5, roads = [[0,1,2],[1,2,10],[0,2,10]]
Output: 5
Explanation: The possible sets of closing branches are:
- The set [2], after closing, active branches are [0,1] and they are reachable within distance 2.
- The set [0,1], after closing, the active branch is [2].
- The set [1,2], after closing, the active branch is [0].
- The set [0,2], after closing, the active branch is [1].
- The set [0,1,2], after closing, there are no active branches.
```

**Example 2:**
```
Input: n = 3, maxDistance = 5, roads = [[0,1,20],[0,1,10],[1,2,2],[0,2,2]]
Output: 7
```

**Example 3:**
```
Input: n = 1, maxDistance = 10, roads = []
Output: 2
```

## Constraints

- `1 <= n <= 10`
- `1 <= maxDistance <= 10^5`
- `0 <= roads.length <= 1000`
- `roads[i].length == 3`
- `0 <= ui, vi <= n - 1`
- `ui != vi`
- `1 <= wi <= 1000`
- All branches are reachable from each other by traveling some roads.
