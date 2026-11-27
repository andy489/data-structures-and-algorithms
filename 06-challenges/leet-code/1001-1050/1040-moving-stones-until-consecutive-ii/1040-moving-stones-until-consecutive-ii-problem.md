# 1040. Moving Stones Until Consecutive II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/moving-stones-until-consecutive-ii/

---

## Problem Statement

There are some stones in different positions on the X-axis. You are given an integer array `stones`, the positions of the stones.

Call a stone an **endpoint stone** if it has the smallest or largest position.

In one move, you pick up an endpoint stone and move it to an **unoccupied** position that is between the minimum and maximum stone positions.

Return an integer array `answer` of length 2 where `answer[0]` is the minimum number of moves and `answer[1]` is the maximum number of moves.

---

## Examples

**Example 1:**
```
Input:  stones = [7,4,9]
Output: [1,2]
```

**Example 2:**
```
Input:  stones = [6,5,4,3,10]
Output: [2,3]
```

---

## Constraints

- `3 <= stones.length <= 10^4`
- `1 <= stones[i] <= 10^9`
- All the values of `stones` are unique.
