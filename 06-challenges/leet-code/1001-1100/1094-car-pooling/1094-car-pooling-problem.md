# 1094. Car Pooling

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/car-pooling/

---

## Problem Statement

There is a car with `capacity` empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer `capacity` and an array `trips` where `trips[i] = [numPassengers_i, from_i, to_i]` indicates that the `i`th trip has `numPassengers_i` passengers and the passengers must be picked up from `from_i` and dropped off at `to_i`.

Return `true` if it is possible to pick up and drop off all passengers for all the given trips, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
```

**Example 2:**
```
Input:  trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
```

---

## Constraints

- `1 <= trips.length <= 1000`
- `trips[i].length == 3`
- `1 <= numPassengers_i <= 100`
- `0 <= from_i < to_i <= 1000`
- `1 <= capacity <= 10^5`
