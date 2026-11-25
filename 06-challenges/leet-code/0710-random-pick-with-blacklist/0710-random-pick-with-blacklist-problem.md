# 710. Random Pick with Blacklist

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/random-pick-with-blacklist/

---

## Problem Statement

You are given an integer `n` and an array of **unique** integers `blacklist`. Design an algorithm to pick a random integer in the range `[0, n - 1]` that is **not** in `blacklist`. Any integer that is not in `blacklist` should be equally likely to be returned.

Optimize your algorithm such that it minimizes the number of calls to the **built-in** random function.

Implement the `Solution` class:
- `Solution(int n, int[] blacklist)` Initializes the object with the integer `n` and the blacklisted integers `blacklist`.
- `int pick()` Returns a random integer in the range `[0, n - 1]` and not in `blacklist`.

---

## Examples

**Example 1:**
```
Input:  ["Solution","pick","pick","pick","pick","pick"]
        [[7,[2,3,5]],[],[],[],[],[]]
Output: [null,0,4,1,6,1]
```

---

## Constraints

- `1 <= n <= 10^9`
- `0 <= blacklist.length <= min(10^5, n - 1)`
- `0 <= blacklist[i] < n`
- All the values of `blacklist` are **unique**.
- At most `2 * 10^4` calls will be made to `pick`.
