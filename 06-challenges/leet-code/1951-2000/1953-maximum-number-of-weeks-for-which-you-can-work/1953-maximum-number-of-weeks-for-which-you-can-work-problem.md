# 1953. Maximum Number of Weeks for Which You Can Work

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/

## Description

There are n projects numbered from 0 to n - 1. You are given an integer array milestones where each milestones[i] denotes the number of milestones the ith project has.

You can work on the projects following these two rules:
- Every week, you will finish exactly one milestone of one project. You must work every week.
- You cannot work on two milestones from the same project for two consecutive weeks.

Once all the milestones of all the projects are finished, or if the only milestones that you can work on will cause you to violate the above rules, you will stop working. Note that you may not be able to finish every project's milestones due to these constraints.

Return the maximum number of weeks you would be able to work on the projects without violating the rules mentioned above.

## Examples

**Example 1:**
```
Input: milestones = [1,2,3]
Output: 6
```

**Example 2:**
```
Input: milestones = [5,2,1]
Output: 7
```

## Constraints

- n == milestones.length
- 1 <= n <= 10^5
- 1 <= milestones[i] <= 10^9
