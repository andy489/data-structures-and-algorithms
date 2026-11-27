# 3376. Minimum Time to Break Locks I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-time-to-break-locks-i/

---

## Problem Statement

Bob is stuck in a dungeon and must break `n` locks, each requiring some amount of **energy** to break. The required energy for each lock is stored in an array called `strength` where `strength[i]` indicates the energy needed to break the `i`-th lock.

To break a lock, Bob uses a sword with the following characteristics:

- The initial energy of the sword is 0.
- The initial factor `x` by which the energy of the sword increases is 1.
- Every minute, the energy of the sword increases by the current factor `x`.
- To break the `i`-th lock, the energy of the sword must reach **at least** `strength[i]`.
- After breaking a lock, the energy of the sword resets to 0, and the factor `x` increases by a given value `k`.

Return the **minimum** time required for Bob to break all `n` locks.

---

## Examples

**Example 1:**
```
Input:  strength = [3,4,1], k = 1
Output: 4
```
Break lock 3 (strength=1) at t=1 with x=1, lock 2 (strength=4) at t=3 with x=2, lock 1 (strength=3) at t=4 with x=3.

**Example 2:**
```
Input:  strength = [2,5,4], k = 2
Output: 5
```
Break lock 1 (strength=2) with x=1, lock 2 (strength=5) with x=3, lock 3 (strength=4) with x=5.

---

## Constraints

- `n == strength.length`
- `1 <= n <= 8`
- `1 <= k <= 10`
- `1 <= strength[i] <= 10^6`
