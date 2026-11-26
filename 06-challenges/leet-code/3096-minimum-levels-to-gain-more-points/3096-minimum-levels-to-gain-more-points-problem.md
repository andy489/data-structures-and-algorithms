# 3096. Minimum Levels to Gain More Points

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-levels-to-gain-more-points/

---

## Problem Statement

You are given a binary array `possible` of length `n`. Alice and Bob are playing a game on `n` levels, indexed 0 to n-1. The levels are played sequentially, Alice plays the first few then Bob plays the rest. Alice gains +1 for possible[i]=1 and -1 for possible[i]=0.

Return the minimum number of levels Alice must play to have strictly more points than Bob, or -1 if it's not possible.

---

## Examples

**Example 1:**
```
Input:  possible = [1,0,1,0]
Output: 1
```

**Example 2:**
```
Input:  possible = [1,1,1,1,1]
Output: 3
```

---

## Constraints

- `2 <= n <= 10^5`
- `possible[i]` is either 0 or 1.
