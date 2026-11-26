# 1298. Maximum Candies You Can Get from Boxes

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/

---

## Problem Statement

Given `n` boxes, the `i`-th box has: `status[i]` (1 if open, 0 if closed), `candies[i]`, `keys[i]` (list of keys to other boxes), and `containedBoxes[i]` (list of boxes inside).

You start with a list `initialBoxes`. Open boxes, collect candies, use keys, follow contained boxes. Return maximum candies.

---

## Examples

**Example 1:**
```
Input:  status=[1,0,1,0],candies=[7,5,4,100],keys=[[],[],[1],[]], containedBoxes=[[1,2],[3],[],[]], initialBoxes=[0]
Output: 16
```

---

## Constraints

- `1 <= status.length <= 1000`
- `status[i] is 0 or 1`
- `1 <= candies[i] <= 1000`
- `0 <= keys[i].length, containedBoxes[i].length <= status.length`
