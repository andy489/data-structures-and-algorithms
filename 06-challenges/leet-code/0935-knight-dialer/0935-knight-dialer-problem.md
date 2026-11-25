# 935. Knight Dialer

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/knight-dialer/

---

## Problem Statement

The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically. The possible movements of chess knight are shown in this diagram.

A chess knight can move as indicated in the chess diagram below.

We have a chess knight and a phone pad. The knight must dial a phone number by moving from key to key. It can dial any digit it starts from, then must move to a valid cell (via knight jump) to dial the next digit.

Given an integer `n`, return how many distinct phone numbers of length `n` we can dial. Since the answer may be very large, return the answer **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  n = 1
Output: 10
```

**Example 2:**
```
Input:  n = 2
Output: 20
```

---

## Constraints

- `1 <= n <= 5000`
