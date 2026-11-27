# 2126. Destroying Asteroids — Solution

**Link:** https://leetcode.com/problems/destroying-asteroids/

## Approach: Greedy — Sort and Absorb

The optimal strategy is to always absorb the smallest available asteroid first. Sort `asteroids` in ascending order. Iterate and greedily absorb. If at any point the current planet mass is less than the next asteroid's mass, return `false`. Otherwise accumulate mass.

Use `long` for the mass sum since it can overflow `int`.

## Complexity

| | Time | Space |
|---|---|---|
| **Sort + Linear Scan** | O(n log n) | O(1) |
