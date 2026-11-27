# 841. Keys and Rooms

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/keys-and-rooms/

---

## Problem Statement

There are `n` rooms labeled from `0` to `n - 1` and all the rooms are locked except for room `0`. Your goal is to visit all the rooms. When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks.

Return `true` if you can visit all the rooms, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  rooms = [[1],[2],[3],[]]
Output: true
```

**Example 2:**
```
Input:  rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter room 2.
```

---

## Constraints

- `n == rooms.length`
- `2 <= n <= 1000`
- `0 <= rooms[i].length <= 1000`
- `1 <= sum(rooms[i].length) <= 3000`
- `0 <= rooms[i][j] < n`
- All values in `rooms[i]` are unique.
