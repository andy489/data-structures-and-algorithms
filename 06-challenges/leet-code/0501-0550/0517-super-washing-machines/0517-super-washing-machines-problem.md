# 517. Super Washing Machines

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/super-washing-machines/

---

## Problem Statement

You have `n` washing machines on a line, and machine `i` has `machines[i]` dresses. You want all machines to have the same number of dresses. In one move, you can transfer one dress from one machine to an adjacent machine. Find the minimum number of moves to equalize, or return `-1` if impossible.

---

## Examples

**Example 1:**
```
Input:  machines = [1,0,5]
Output: 3
```

**Example 2:**
```
Input:  machines = [0,3,0]
Output: 2
```

**Example 3:**
```
Input:  machines = [0,2,0]
Output: -1
```

---

## Constraints

- `n == machines.length`
- `1 <= n <= 10^4`
- `0 <= machines[i] <= 10^5`
