# 3885. Design Event Manager

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-event-manager/

## Problem

You are given an initial list of events, where each event has a unique `eventId` and a `priority`.

Implement the `EventManager` class:
- `EventManager(int[][] events)` Initializes the manager with the given events, where `events[i] = [eventId_i, priority_i]`.
- `void updatePriority(int eventId, int newPriority)` Updates the priority of the **active** event with id `eventId` to `newPriority`.
- `int pollHighest()` Removes and returns the `eventId` of the **active** event with the **highest** priority. If multiple active events have the same priority, return the **smallest** `eventId` among them. If there are no active events, return -1.

An event is called **active** if it has not been removed by `pollHighest()`.

## Examples

**Example 1:**
```
Input: ["EventManager","pollHighest","updatePriority","pollHighest","pollHighest"]
       [[[[5,7],[2,7],[9,4]]], [], [9,7], [], []]
Output: [null, 2, null, 5, 9]
```

**Example 2:**
```
Input: ["EventManager","pollHighest","pollHighest","pollHighest"]
       [[[[4,1],[7,2]]], [], [], []]
Output: [null, 7, 4, -1]
```

## Constraints

- `1 <= events.length <= 10^5`
- `1 <= eventId, priority <= 10^9`
- All eventId values are unique.
- `1 <= newPriority <= 10^9`
- At most `10^5` calls to `updatePriority` and `pollHighest`.
