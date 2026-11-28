# 3480. Maximize Subarrays After Removing One Conflicting Pair

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair/

---

## Problem Statement

You are given an integer `n` which represents an array `nums` containing the numbers from 1 to `n` in order. Additionally, you are given a 2D array `conflictingPairs`, where `conflictingPairs[i] = [a, b]` indicates that `a` and `b` form a conflicting pair.

Remove **exactly** one element from `conflictingPairs`. Afterward, count the number of non-empty subarrays of `nums` which do not contain both `a` and `b` for any remaining conflicting pair `[a, b]`.

Return the **maximum** number of subarrays possible after removing **exactly** one conflicting pair.

---

## Examples

**Example 1:**
```
Input: n = 4, conflictingPairs = [[2,3],[1,4]]
Output: 9
Explanation: Remove [2,3]. Remaining: [[1,4]]. 9 subarrays don't contain both 1 and 4.
```

**Example 2:**
```
Input: n = 5, conflictingPairs = [[1,2],[2,5],[3,5]]
Output: 12
Explanation: Remove [1,2]. Remaining: [[2,5],[3,5]]. 12 subarrays are valid.
```

---

## Constraints

- `2 <= n <= 10^5`
- `1 <= conflictingPairs.length <= 2 * n`
- `conflictingPairs[i].length == 2`
- `1 <= conflictingPairs[i][j] <= n`
- `conflictingPairs[i][0] != conflictingPairs[i][1]`
