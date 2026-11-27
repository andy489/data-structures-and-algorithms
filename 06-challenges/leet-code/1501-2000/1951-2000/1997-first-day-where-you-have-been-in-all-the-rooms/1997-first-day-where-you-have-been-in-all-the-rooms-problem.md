# 1997. First Day Where You Have Been in All the Rooms

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/first-day-where-you-have-been-in-all-the-rooms/

## Description

There are `n` rooms you need to visit, labeled from `0` to `n - 1`. Each day is labeled, starting from `0`. You will go in and visit one room a day.

Initially on day `0`, you visit room `0`. The order you visit the rooms for the coming days is determined by the following rules and a given 0-indexed array `nextVisit` of length `n`:

- Assuming that on a day, you visit room `i`:
  - if you have been in room `i` an **odd** number of times (including the current visit), on the next day you will visit a room with a lower or equal room number specified by `nextVisit[i]` where `0 <= nextVisit[i] <= i`;
  - if you have been in room `i` an **even** number of times (including the current visit), on the next day you will visit room `(i + 1) mod n`.

Return the label of the first day where you have been in all the rooms. Since the answer may be very large, return it modulo `10^9 + 7`.

## Examples

**Example 1:**
```
Input: nextVisit = [0,0]
Output: 2
```

**Example 2:**
```
Input: nextVisit = [0,0,2]
Output: 6
```

**Example 3:**
```
Input: nextVisit = [0,1,2,0]
Output: 6
```

## Constraints

- `n == nextVisit.length`
- `2 <= n <= 10^5`
- `0 <= nextVisit[i] <= i`
