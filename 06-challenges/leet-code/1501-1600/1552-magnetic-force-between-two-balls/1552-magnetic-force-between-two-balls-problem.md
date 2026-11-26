# 1552. Magnetic Force Between Two Balls

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/magnetic-force-between-two-balls/

---

## Problem Statement

In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has `n` empty baskets, the `i`th basket is at `position[i]`, Rick wants to put `m` balls into the baskets such that the **minimum magnetic force** between any two balls is **maximum**.

Rick knows that if two balls are put at positions `x` and `y` respectively, the magnetic force between them is `|x - y|`.

Given the integer array `position` and the integer `m`, return the required force.

---

## Examples

**Example 1:**
```
Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
```

**Example 2:**
```
Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.
```

---

## Constraints
- `2 <= n <= 10^5`
- `1 <= position[i] <= 10^9`
- All integers in `position` are **distinct**.
- `2 <= m <= position.length`
