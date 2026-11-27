# 1109. Corporate Flight Bookings

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/corporate-flight-bookings/

---

## Problem Statement

There are `n` flights labeled from `1` to `n`.

You are given an array of flight bookings `bookings`, where `bookings[i] = [first_i, last_i, seats_i]` represents a booking for flights `first_i` through `last_i` (inclusive) with `seats_i` seats reserved for each flight in the range.

Return an array `answer` of length `n`, where `answer[i]` is the total number of seats reserved for flight `i`.

---

## Examples

**Example 1:**
```
Input:  bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10, 55, 45, 25, 25]
```

**Example 2:**
```
Input:  bookings = [[1,2,10],[2,2,15]], n = 2
Output: [10, 25]
```

---

## Constraints

- `1 <= n <= 2 * 10^4`
- `1 <= bookings.length <= 2 * 10^4`
- `bookings[i].length == 3`
- `1 <= first_i <= last_i <= n`
- `1 <= seats_i <= 10^4`
