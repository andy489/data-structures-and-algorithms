# 871. Minimum Number of Refueling Stops

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-refueling-stops/

---

## Problem Statement

A car travels from a starting position to a destination which is `target` miles east of the starting position.

There are gas stations along the way. The gas stations are represented as an array `stations` where `stations[i] = [position_i, fuel_i]` indicates that the `i`th gas station is `position_i` miles east of the starting position and has `fuel_i` liters of gas.

The car starts with an infinite tank of gas, which initially has `startFuel` liters of fuel. When the car reaches a gas station, it may stop and refuel any amount of gas. If the car runs out of fuel, it stops.

Return the minimum number of refueling stops the car must make to reach its destination. If it cannot reach the destination, return `-1`.

---

## Examples

**Example 1:**
```
Input:  target = 1, startFuel = 1, stations = []
Output: 0
```

**Example 2:**
```
Input:  target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
```

**Example 3:**
```
Input:  target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
```

---

## Constraints

- `1 <= target, startFuel <= 10^9`
- `0 <= stations.length <= 500`
- `1 <= stations[i][0] < stations[i][1] < target`
- `1 <= stations[i][1] <= 10^9`
