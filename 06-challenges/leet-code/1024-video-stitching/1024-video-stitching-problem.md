# 1024. Video Stitching

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/video-stitching/

---

## Problem Statement

You are given a series of video clips from a sporting event that lasted `time` seconds. These video clips can be overlapping with each other and can vary in length.

Each video clip is described by an array `clips` where `clips[i] = [starti, endi]` indicates a clip that began at time `starti` and ended at time `endi`.

We can cut these clips into segments freely.

Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event `[0, time]`. If the task is impossible, return `-1`.

---

## Examples

**Example 1:**
```
Input:  clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
Output: 3
```

---

## Constraints

- `1 <= clips.length <= 100`
- `0 <= starti <= endi <= 100`
- `1 <= time <= 100`
