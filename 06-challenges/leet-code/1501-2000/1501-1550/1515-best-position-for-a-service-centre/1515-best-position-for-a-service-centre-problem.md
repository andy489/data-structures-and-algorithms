# 1515. Best Position for a Service Centre

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/best-position-for-a-service-centre/

---

## Problem Statement

A delivery company wants to build a new service centre in a new city. The company knows the positions of all the customers in this city on a map and wants to build the new centre in a position such that **the sum of the euclidean distances to all customers is minimum**.

Given an array `positions` where `positions[i] = [xi, yi]` is the position of the `i`th customer on the map, return the minimum sum of the euclidean distances to all customers.

Your answer is accepted if the difference from the true minimum is at most `10^-5`.

---

## Examples

**Example 1:**
```
Input:  positions = [[0,1],[1,0],[1,2],[2,1]]
Output: 4.00000
Explanation: As shown, you can see that A[0]+A[1]+A[2]+A[3] = 2+√2+√2 = 4.00 (3 is wrong, A is [2,√2,√2,0] no). The best position is at (1,1) which gives sum = 4.
```

**Example 2:**
```
Input:  positions = [[1,1],[3,3]]
Output: 2.82843
Explanation: The minimum sum of distances is sqrt(8) ≈ 2.82843.
```

---

## Constraints

- `1 <= positions.length <= 50`
- `positions[i].length == 2`
- `0 <= xi, yi <= 100`
