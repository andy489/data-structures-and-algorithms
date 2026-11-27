# 1776. Car Fleet II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/car-fleet-ii/

---

## Problem Statement

There are `n` cars traveling at different speeds in the same direction along a one-lane road. You are given an array `cars` of length `n`, where `cars[i] = [positioni, speedi]` represents:

- `positioni` is the position of the `i`th car.
- `speedi` is the speed of the `i`th car.

For simplicity, cars can be considered as points moving along a number line. Two cars collide when they occupy the same position. Once a car collides with another car, they unite and form a single car fleet. The cars in the formed fleet will have the same position and the same speed, which is the **minimum initial speed** of the two colliding cars.

Note that no two cars will have the same initial position.

Design a function that returns an array `answer`, where `answer[i]` is the time, in seconds, at which the `i`th car collides with the next car fleet.

Return an array `answer`, where `answer[i]` is the time at which the `i`th car collides with the next car fleet, or `-1` if the car does not collide with the next fleet.

---

## Examples

**Example 1:**
```
Input: cars = [[1,2],[2,1],[4,3],[7,2]]
Output: [1.00000,-1.00000,3.00000,-1.00000]
Explanation: After exactly one second, the first car will collide with the second car, and form a car fleet with speed 1. After exactly 3 seconds, the third car will collide with the fourth car, and form a car fleet with speed 2. The second car will not collide with anything; it is already in a fleet. Note that no other collision occurs.
```

**Example 2:**
```
Input: cars = [[3,4],[5,4],[6,3],[9,1]]
Output: [2.00000,1.00000,1.50000,-1.00000]
```

---

## Constraints

- `1 <= cars.length <= 10^5`
- `1 <= positioni, speedi <= 10^6`
- All the positions are **unique**.
