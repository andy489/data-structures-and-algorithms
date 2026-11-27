# 886. Possible Bipartition

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/possible-bipartition/

---

## Problem Statement

We want to split a group of `n` people (labeled from `1` to `n`) into two groups of any size.

Each person may dislike some other people, and they should not go into the same group.

Given the integer `n` and the array `dislikes` where `dislikes[i] = [ai, bi]` indicates that the people labeled `ai` and `bi` dislike each other, return `true` if it is possible to split everyone into two groups in this way.

---

## Examples

**Example 1:**
```
Input:  n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
```

**Example 2:**
```
Input:  n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
```

---

## Constraints

- `1 <= n <= 2000`
- `0 <= dislikes.length <= 10^4`
- `dislikes[i].length == 2`
- `1 <= ai < bi <= n`
- All the pairs of dislikes are unique.
