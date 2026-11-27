# 732. My Calendar III

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/my-calendar-iii/

---

## Problem Statement

A `k`-booking happens when `k` events have some non-empty intersection (i.e., there is some time that is common to all `k` events.)

You are given some events `[startTime, endTime)`, after each given event, return an integer `k` representing the maximum `k`-booking between all the previous events.

Implement the `MyCalendarThree` class:

- `MyCalendarThree()` Initializes the object.
- `int book(int startTime, int endTime)` Returns an integer `k` representing the maximum `k`-booking after adding the event.

---

## Examples

**Example 1:**
```
Input:  ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
        [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
Output: [null, 1, 1, 2, 3, 3, 3]
```

---

## Constraints

- `0 <= startTime < endTime <= 10^9`
- At most `400` calls will be made to `book`.
