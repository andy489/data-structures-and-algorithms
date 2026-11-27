# 3386. Button with Longest Push Time

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/button-with-longest-push-time/

---

## Problem Statement

You are given a 2D array `events` which represents a sequence of events where a child pushes a series of buttons on a keyboard.

Each `events[i] = [indexi, timei]` indicates that the button at index `indexi` was pressed at time `timei`.

- The array is **sorted** in increasing order of `time`.
- The time taken to press a button is the difference in time between consecutive button presses. The time for the first button is simply the time at which it was pressed.

Return the `index` of the button that took the **longest** time to push. If multiple buttons have the same longest time, return the button with the **smallest** `index`.

---

## Examples

**Example 1:**
```
Input:  events = [[1,2],[2,5],[3,9],[1,15]]
Output: 1
```
Explanation:
- Button 1 pressed at time 2 → duration 2.
- Button 2 pressed at time 5 → duration 3.
- Button 3 pressed at time 9 → duration 4.
- Button 1 pressed at time 15 → duration 6.
Button 1 has longest total push time of 6.

**Example 2:**
```
Input:  events = [[10,5],[1,7]]
Output: 10
```
Explanation: Button 10 → duration 5; Button 1 → duration 2. Button 10 wins.

---

## Constraints

- `1 <= events.length <= 1000`
- `events[i] == [indexi, timei]`
- `1 <= indexi, timei <= 10^5`
- `events` is sorted in increasing order of `timei`.
