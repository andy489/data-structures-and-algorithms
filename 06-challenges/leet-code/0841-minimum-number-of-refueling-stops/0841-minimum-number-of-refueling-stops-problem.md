# 841. Minimum Number of Refueling Stops

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/minimum-number-of-refueling-stops/

---

## Problem Statement

A car travels from a starting position to a destination which is `target` miles east of the starting position.

There are gas stations along the way. The `i`-th gas station is at position `stations[i][0]` miles east of the starting position and has `stations[i][1]` liters of gas.

The car starts with an infinite tank of gas, which initially has `startFuel` liters of fuel. It uses one liter of gas per mile.

When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

Return the **minimum number of refueling stops** the car must make to reach its destination. If it cannot reach the destination, return `-1`.

---

## Examples

| Input | Output | Explanation |
|-------|--------|-------------|
| `target=1`, `startFuel=1`, `stations=[]` | `0` | Can reach target with no stops |
| `target=100`, `startFuel=1`, `stations=[[10,100]]` | `-1` | Cannot reach target |
| `target=100`, `startFuel=10`, `stations=[[10,60],[20,30],[30,30],[60,40]]` | `2` | Stop at 10 (60L), stop at 60 (40L) → total 2 stops |

---

## Constraints

- `1 <= target, startFuel <= 10^9`
- `0 <= stations.length <= 500`
- `0 <= stations[i][0] <= target`
- `1 <= stations[i][1] <= 10^9`
- Stations are given in **increasing order** of position
- All positions are distinct
