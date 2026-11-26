# 1751. Maximum Number of Events That Can Be Attended II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/

---

## Problem Statement

You are given an array of `events` where `events[i] = [startDayi, endDayi, valuei]`. The `i`th event starts at `startDayi` and ends at `endDayi`, and if you attend this event, you will receive a value of `valuei`. You are also given an integer `k` which represents the maximum number of events you can attend.

You can only attend one event at a time. If you choose to attend an event, you must attend the **entire** event. Note that the end day is **inclusive**: that is, you cannot attend two events where one of them starts and the other ends on the same day.

Return the **maximum sum** of values that you can receive by attending events.

---

## Examples

**Example 1:**
```
Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
Output: 7
Explanation: Choose events 0 and 1 for a total value of 4 + 3 = 7.
```

**Example 2:**
```
Input: events = [[1,2,4],[3,4,3],[2,3,10]], k = 2
Output: 10
Explanation: Choose event 2 alone for a value of 10.
```

**Example 3:**
```
Input: events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3
Output: 9
Explanation: Choose the last 3 events for a total value of 2 + 3 + 4 = 9.
```

---

## Constraints

- `1 <= k <= events.length`
- `1 <= k * events.length <= 10^6`
- `1 <= startDayi <= endDayi <= 10^9`
- `1 <= valuei <= 10^6`
