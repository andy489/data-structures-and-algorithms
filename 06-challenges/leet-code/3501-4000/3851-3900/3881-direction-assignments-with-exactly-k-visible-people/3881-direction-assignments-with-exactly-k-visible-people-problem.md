# 3881. Direction Assignments with Exactly K Visible People

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/direction-assignments-with-exactly-k-visible-people/

## Problem

You are given three integers `n`, `pos`, and `k`.

There are `n` people standing in a line indexed from 0 to `n - 1`. Each person **independently** chooses a direction:
- `'L'`: **visible** only to people on their **right**
- `'R'`: **visible** only to people on their **left**

A person at index `pos` sees others as follows:
- A person `i < pos` is visible if and only if they choose `'L'`.
- A person `i > pos` is visible if and only if they choose `'R'`.

Return the number of possible direction assignments such that the person at index `pos` sees **exactly** `k` people.

Since the answer may be large, return it **modulo** `10^9 + 7`.

## Examples

**Example 1:**
```
Input: n = 3, pos = 1, k = 0
Output: 2
Explanation: To see k=0 people, index 0 must choose 'R' and index 2 must choose 'L'. Person at pos=1 can choose either direction -> 2 ways.
```

**Example 2:**
```
Input: n = 3, pos = 2, k = 1
Output: 4
```

**Example 3:**
```
Input: n = 1, pos = 0, k = 0
Output: 2
```

## Constraints

- `1 <= n <= 10^5`
- `0 <= pos <= n - 1`
- `0 <= k <= n - 1`
