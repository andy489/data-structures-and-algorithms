# 1603. Design Parking System

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/design-parking-system/

---

## Problem Statement

Design a parking system for a parking lot. The lot has three types of parking spaces: big, medium, and small, with a fixed number of slots for each size.

Implement the `ParkingSystem` class:
- `ParkingSystem(int big, int medium, int small)` Initializes object of the `ParkingSystem` class. The number of slots for each parking space are given as part of the constructor.
- `bool addCar(int carType)` Checks whether there is a parking space of `carType` for the car that wants to get into the parking lot. `carType` can be of three kinds: big, medium, or small, which are represented by `1`, `2`, and `3` respectively. A car can only park in a parking space of its `carType`. If there is no space available, return `false`, else park the car in that size space and return `true`.

---

## Examples

**Example 1:**
```
Input: ["ParkingSystem","addCar","addCar","addCar","addCar"]
       [[1,1,0],[1],[2],[3],[1]]
Output: [null,true,true,false,false]
Explanation:
  ParkingSystem(1,1,0): 1 big, 1 medium, 0 small.
  addCar(1) → true  (big slot taken)
  addCar(2) → true  (medium slot taken)
  addCar(3) → false (no small slots)
  addCar(1) → false (no more big slots)
```

---

## Constraints

- `0 <= big, medium, small <= 1000`
- `carType` is `1`, `2`, or `3`
- At most `1000` calls will be made to `addCar`
