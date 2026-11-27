# 2054. Two Best Non-Overlapping Events

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/two-best-non-overlapping-events/

---

## Problem Statement

You are given a 2D array `events` where `events[i] = [startTime, endTime, value]`. Attend at most two non-overlapping events to maximize the sum of values. Return the maximum sum.

---

## Examples

**Example 1:**
```
Input:  events = [[1,3,2],[4,5,2],[2,4,3]]
Output: 4
```
Explanation: Events 0 and 1 are non-overlapping: 2+2=4.

**Example 2:**
```
Input:  events = [[1,3,2],[4,5,2],[1,5,5]]
Output: 5
```
Explanation: Event 2 alone gives 5.

**Example 3:**
```
Input:  events = [[1,5,3],[1,5,1],[6,6,5]]
Output: 8
```
Explanation: Events 0 and 2: 3+5=8.

---

## Constraints

- `2 <= events.length <= 10^5`
- `events[i].length == 3`
- `1 <= startTime <= endTime <= 10^9`
- `1 <= value <= 10^6`
