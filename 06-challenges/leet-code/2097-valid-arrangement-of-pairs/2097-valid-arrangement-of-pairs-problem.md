# 2097. Valid Arrangement of Pairs

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/valid-arrangement-of-pairs/

---

## Problem Statement

You have pairs `[starti, endi]`. Arrange all pairs so that for every consecutive pair of arranged pairs: the end of one equals the start of the next. Return any valid arrangement.

---

## Examples

**Example 1:**
```
Input:  pairs = [[5,1],[4,5],[11,9],[9,4]]
Output: [[11,9],[9,4],[4,5],[5,1]]
```

**Example 2:**
```
Input:  pairs = [[1,3],[3,2],[2,1]]
Output: [[1,3],[3,2],[2,1]]
```

**Example 3:**
```
Input:  pairs = [[1,2],[1,3],[2,1]]
Output: [[1,2],[2,1],[1,3]]
```

---

## Constraints

- `1 <= pairs.length <= 10^5`
- `pairs[i].length == 2`
- `0 <= starti, endi <= 10^9`
