# 3440. Reschedule Meetings for Maximum Free Time II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/

## Problem

You are given an integer `eventTime` denoting the duration of an event. You are also given two integer arrays `startTime` and `endTime`, each of length `n`.

These represent the start and end times of `n` non-overlapping meetings that occur during the event between time `t = 0` and time `t = eventTime`, where the `i`th meeting occurs during the time `[startTime[i], endTime[i]]`.

You can reschedule **at most one meeting** by moving its start time while maintaining the same duration, such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings cannot be rescheduled to a time outside the event and they should remain non-overlapping.

**Note:** In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.

## Examples

**Example 1:**
```
Input: eventTime = 5, startTime = [1,3], endTime = [2,5]
Output: 2
```

**Example 2:**
```
Input: eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]
Output: 7
```

**Example 3:**
```
Input: eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]
Output: 6
```

**Example 4:**
```
Input: eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
Output: 0
```

## Constraints

- `1 <= eventTime <= 10^9`
- `n == startTime.length == endTime.length`
- `2 <= n <= 10^5`
- `0 <= startTime[i] < endTime[i] <= eventTime`
- `endTime[i] <= startTime[i + 1]` where `i` lies in the range `[0, n - 2]`.
