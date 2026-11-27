# 1042. Flower Planting With No Adjacent

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flower-planting-with-no-adjacent/

---

## Problem Statement

You have `n` gardens, labelled `1` to `n`, and an array `paths` where `paths[i] = [xi, yi]` describes a bidirectional path between garden `xi` and garden `yi`. Each garden is connected to at most 3 other gardens.

You want to choose 1 of 4 flower types for each garden such that any two gardens connected by a path have different types.

Return *any* such choice as an array `answer` where `answer[i]` is the type of flower planted in the `(i+1)`th garden.

---

## Examples

**Example 1:**
```
Input:  n = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]
```

**Example 2:**
```
Input:  n = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]
```

---

## Constraints

- `1 <= n <= 10^4`
- `0 <= paths.length <= 2 * 10^4`
- `paths[i].length == 2`
- `1 <= xi, yi <= n`
- `xi != yi`
- Every garden has at most 3 paths coming into or leaving it.
