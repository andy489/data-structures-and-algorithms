# 731. My Calendar II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/my-calendar-ii/

---

## Problem Statement

You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a **triple booking**.

A **triple booking** happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).

The event can be represented as a pair of integers `start` and `end` that represents a booking on the half-open interval `[start, end)`, the range of real numbers `x` such that `start <= x < end`.

Implement the `MyCalendarTwo` class:

- `MyCalendarTwo()` Initializes the calendar object.
- `boolean book(int start, int end)` Returns `true` if the event can be added to the calendar successfully without causing a **triple booking**. Otherwise, return `false` and do not add the event to the calendar.

---

## Examples

**Example 1:**
```
Input:  ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
        [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
Output: [null, true, true, true, false, true, true]
```

---

## Constraints

- `0 <= start < end <= 10^9`
- At most `1000` calls will be made to `book`.
