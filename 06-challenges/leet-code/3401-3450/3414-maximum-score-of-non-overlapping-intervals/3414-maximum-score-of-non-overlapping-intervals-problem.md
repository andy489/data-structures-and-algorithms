# 3414. Maximum Score of Non-overlapping Intervals

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/

## Problem

You are given intervals[i] = [li, ri, weighti]. Choose up to 4 non-overlapping intervals to maximize total weight. Two intervals sharing a boundary are considered overlapping.

Return the lexicographically smallest array of at most 4 indices achieving maximum score.

## Examples

**Example 1:**

Input: intervals = [[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]
Output: [2,3]

Explanation: Intervals 2 (weight 5) and 3 (weight 3) don't overlap, total = 8.

**Example 2:**

Input: intervals = [[5,8,1],[6,7,7],[4,7,3],[9,10,6],[7,8,2],[11,14,3],[3,5,5]]
Output: [1,3,5,6]

## Constraints

- 1 <= intervals.length <= 5 * 10^4
- intervals[i] = [li, ri, weighti]
- 1 <= li <= ri <= 10^9
- 1 <= weighti <= 10^9
