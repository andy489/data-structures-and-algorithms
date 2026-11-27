# 2126. Destroying Asteroids

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/destroying-asteroids/

## Problem

You are given an integer `mass`, which represents the original mass of a planet. You are further given an integer array `asteroids`, where `asteroids[i]` is the mass of the ith asteroid.

You can arrange for the planet to collide with the asteroids in any arbitrary order. If the mass of the planet is greater than or equal to the mass of the asteroid, the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is destroyed.

Return `true` if all asteroids can be destroyed. Otherwise, return `false`.

## Examples

**Example 1:**
```
Input: mass = 10, asteroids = [3,9,19,5,21]
Output: true
Explanation: Order [9,19,5,3,21]:
- 10 >= 9 → mass = 19
- 19 >= 19 → mass = 38
- 38 >= 5 → mass = 43
- 43 >= 3 → mass = 46
- 46 >= 21 → mass = 67
```

**Example 2:**
```
Input: mass = 5, asteroids = [4,9,23,4]
Output: false
Explanation: Planet cannot gain enough mass to destroy the asteroid with mass 23.
After all others: 5+4+9+4=22 < 23.
```

## Constraints

- `1 <= mass <= 10^5`
- `1 <= asteroids.length <= 10^5`
- `1 <= asteroids[i] <= 10^5`
