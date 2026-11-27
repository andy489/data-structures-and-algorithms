# 851. Loud and Rich

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/loud-and-rich/

---

## Problem Statement

There is a group of `n` people labeled from `0` to `n - 1` where each person has a different amount of money and a different level of quietness.

You are given an array `richer` where `richer[i] = [ai, bi]` indicates that `ai` has more money than `bi` and an integer array `quiet` where `quiet[i]` is the quietness of the `i`th person.

Return an integer array `answer` where `answer[x] = y` if `y` is the least quiet person (that is, the person `y` with the smallest value of `quiet[y]`) among all people who definitely have equal to or more money than the person `x`.

---

## Examples

**Example 1:**
```
Input:  richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
Output: [5,5,2,5,4,5,6,7]
```

**Example 2:**
```
Input:  richer = [], quiet = [0]
Output: [0]
```

---

## Constraints

- `n == quiet.length`
- `1 <= n <= 500`
- `0 <= quiet[i] < n`
- All values of `quiet` are unique.
- `0 <= richer.length <= n * (n - 1) / 2`
- `0 <= ai, bi < n`
- `ai != bi`
- All pairs in `richer` are unique.
- The observations in `richer` are logically consistent.
