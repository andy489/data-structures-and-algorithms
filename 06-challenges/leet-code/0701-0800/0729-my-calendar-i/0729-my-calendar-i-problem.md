# 729. My Calendar I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/my-calendar-i/

---

## Problem Statement

You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a **double booking**.

A **double booking** happens when two events have some non-empty intersection (i.e., some moment is common to both events).

The event can be represented as a pair of integers `startTime` and `endTime` that represents a booking on the half-open interval `[startTime, endTime)`.

Implement the `MyCalendar` class:
- `MyCalendar()` Initializes the calendar object.
- `boolean book(int startTime, int endTime)` Returns `true` if the event can be added to the calendar successfully without causing a double booking. Otherwise, return `false` and do not add the event.

---

## Examples

**Example 1:**
```
Input:  ["MyCalendar","book","book","book"]
        [[],[10,20],[15,25],[20,30]]
Output: [null,true,false,true]
```

---

## Constraints

- `0 <= startTime < endTime <= 10^9`
- At most `1000` calls will be made to `book`.
