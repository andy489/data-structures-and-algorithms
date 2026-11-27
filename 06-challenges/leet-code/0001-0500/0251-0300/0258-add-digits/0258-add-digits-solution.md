# 258. Add Digits — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/add-digits/

---

## Solution 1: Digital Root (Math) — O(1) time, O(1) space

**Idea:** The digital root of a number is `1 + (num - 1) % 9` for `num > 0`, and `0` for `num == 0`. This follows from the property of modulo 9 (casting out nines).

**Algorithm:**
1. If `num == 0`, return `0`.
2. Otherwise, return `1 + (num - 1) % 9`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — constant formula |
| Space | O(1) — no extra space |

---

## Solution 2: Simulation — O(log num) time, O(1) space

**Idea:** Repeatedly sum digits until a single digit remains.

**Complexity:**

| | |
|---|---|
| Time | O(log num) — number of iterations proportional to digits |
| Space | O(1) — no extra space |
