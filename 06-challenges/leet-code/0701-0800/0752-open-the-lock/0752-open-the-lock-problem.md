# 752. Open the Lock

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/open-the-lock/

---

## Problem Statement

You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: `'0', '1', '2', ..., '9'`. The wheels can rotate freely and wrap around: for example we can turn `'9'` to be `'0'`, or `'0'` to be `'9'`. Each move consists of turning one wheel one slot.

The lock initially starts at `'0000'`, a string representing the state of the 4 wheels.

You are given a list of `deadends` dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a `target` representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

---

## Examples

**Example 1:**
```
Input:  deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
```

**Example 2:**
```
Input:  deadends = ["8888"], target = "0009"
Output: 1
```

---

## Constraints

- `1 <= deadends.length <= 500`
- `deadends[i].length == 4`
- `target.length == 4`
- `target` will not be in the list of `deadends`.
- `target` and `deadends[i]` consist of digits.
