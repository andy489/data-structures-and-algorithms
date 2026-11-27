# 2211. Count Collisions on a Road

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/count-collisions-on-a-road/

## Problem

There are n cars on an infinitely long road. The cars are numbered from 0 to n - 1 from left to right and each car is present at a unique point.

You are given a 0-indexed string directions of length n. directions[i] can be either 'L', 'R', or 'S' denoting whether the ith car is moving towards the left, towards the right, or staying at its current point respectively. Each moving car has the same speed.

The number of collisions can be calculated as follows:
- When two cars moving in opposite directions collide with each other, the number of collisions increases by 2.
- When a moving car collides with a stationary car, the number of collisions increases by 1.

After a collision, the cars involved can no longer move and will stay at the point where they collided.

Return the total number of collisions that will happen on the road.

## Examples

**Example 1:**
```
Input: directions = "RLRSLL"
Output: 5
```

**Example 2:**
```
Input: directions = "LLRR"
Output: 0
```

## Constraints

- 1 <= directions.length <= 10⁵
- directions[i] is either 'L', 'R', or 'S'.
