# 1710. Maximum Units on a Truck

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-units-on-a-truck/

---

## Problem Statement

You are assigned to put some amount of boxes onto **one truck**. You are given a 2D array `boxTypes`, where `boxTypes[i] = [numberOfBoxes_i, numberOfUnitsPerBox_i]`:

- `numberOfBoxes_i` is the number of boxes of type `i`.
- `numberOfUnitsPerBox_i` is the number of units in each box of the type `i`.

You are also given an integer `truckSize`, which is the **maximum** number of **boxes** that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed `truckSize`.

Return the **maximum** total number of **units** that can be put on the truck.

---

## Examples

**Example 1:**
```
Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: (1*3) + (2*2) + (1*1) = 8
```

**Example 2:**
```
Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91
```

---

## Constraints

- `1 <= boxTypes.length <= 1000`
- `1 <= numberOfBoxes_i, numberOfUnitsPerBox_i <= 1000`
- `1 <= truckSize <= 10^6`
