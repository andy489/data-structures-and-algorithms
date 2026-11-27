# 3386. Button with Longest Push Time — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/button-with-longest-push-time/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** The push duration for each event is `events[i][1] - events[i-1][1]` (or `events[0][1]` for the first event). Track the maximum duration and the corresponding button index, using the smallest index as tiebreaker.

**Algorithm:**
1. Initialize `bestIdx = events[0][0]`, `bestTime = events[0][1]`.
2. For each subsequent event `i`, compute `duration = events[i][1] - events[i-1][1]`.
3. If `duration > bestTime`, update. If `duration == bestTime` and `events[i][0] < bestIdx`, update index only.
4. Return `bestIdx`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
