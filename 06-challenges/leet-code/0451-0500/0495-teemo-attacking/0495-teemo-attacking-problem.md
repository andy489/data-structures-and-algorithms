# 495. Teemo Attacking

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/teemo-attacking/

---

## Problem Statement

Our hero Teemo is attacking an enemy Ashe with poison attacks. When Teemo attacks Ashe, Ashe gets poisoned for exactly `duration` seconds. More formally, an attack at second `t` will mean Ashe is poisoned during the **inclusive** time interval `[t, t + duration - 1]`. If Teemo attacks again **before** the poison effect ends, the timer for it is **reset**, and the poison effect will end `duration` seconds after the new attack.

You are given a **non-decreasing** integer array `timeSeries`, where `timeSeries[i]` denotes that Teemo attacks Ashe at second `timeSeries[i]`, and an integer `duration`.

Return *the **total** number of seconds that Ashe is poisoned*.

---

## Examples

**Example 1:**
```
Input:  timeSeries = [1, 4], duration = 2
Output: 4
Explanation: Attacks at t=1 (poisoned 1–2) and t=4 (poisoned 4–5) → 4 seconds total.
```

**Example 2:**
```
Input:  timeSeries = [1, 2], duration = 2
Output: 3
Explanation: Attack at t=1 (poisoned 1–2), attack at t=2 resets (poisoned 2–3) → 3 seconds total.
```

---

## Constraints

- `1 <= timeSeries.length <= 10^4`
- `0 <= timeSeries[i], duration <= 10^7`
- `timeSeries` is sorted in **non-decreasing** order
