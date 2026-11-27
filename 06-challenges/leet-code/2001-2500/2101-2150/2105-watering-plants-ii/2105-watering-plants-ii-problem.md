# 2105. Watering Plants II

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/watering-plants-ii/

---

## Problem Statement

Alice and Bob want to water `n` plants in their garden. The plants are arranged in a row and are labeled from `0` to `n - 1` from left to right where the ith plant is located at `x = i`.

Each plant needs a specific amount of water. Alice and Bob have a watering can each, initially full. They water the plants in the following way:

- Alice waters the plants in order from left to right, starting from the 0th plant. Bob waters the plants in order from right to left, starting from the (n - 1)th plant. They begin watering the plants simultaneously.
- It takes the same amount of time to water each plant regardless of how much water it needs.
- Alice/Bob must water the plant if they have enough in their can to fully water it. Otherwise, they first refill their can (instantaneously) then water the plant.
- In case both Alice and Bob reach the same plant, the one with more water currently in his/her watering can should water this plant. If they have the same amount of water, then Alice should water this plant.

Given a 0-indexed integer array `plants` of `n` integers, where `plants[i]` is the amount of water the ith plant needs, and two integers `capacityA` and `capacityB` representing the capacities of Alice's and Bob's watering cans respectively, return the **number of times they have to refill** to water all the plants.

---

## Examples

**Example 1:**
```
Input:  plants = [2,2,3,3], capacityA = 5, capacityB = 5
Output: 1
```

**Example 2:**
```
Input:  plants = [2,2,3,3], capacityA = 3, capacityB = 4
Output: 2
```

**Example 3:**
```
Input:  plants = [5], capacityA = 10, capacityB = 8
Output: 0
Explanation: Only one plant; Alice has more water so she waters it.
```

---

## Constraints

- `n == plants.length`
- `1 <= n <= 10^5`
- `1 <= plants[i] <= 10^6`
- `max(plants[i]) <= capacityA, capacityB <= 10^9`
