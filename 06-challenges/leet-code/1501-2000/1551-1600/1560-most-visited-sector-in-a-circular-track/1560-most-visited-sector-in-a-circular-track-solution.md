# 1560. Most Visited Sector in a Circular Track — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/most-visited-sector-in-a-circular-track/

---

## Solution: Start and End Comparison — O(n) time, O(n) space

**Idea:** Only the first and last sector of the entire journey matter. Any full lap visits all sectors equally, so after cancellation the sectors visited more are determined solely by the partial lap from `start` to `end`. If start <= end, that range is visited more. If start > end, the wrap-around from start..n and 1..end is visited more.

**Algorithm:**
1. Take `start = rounds[0]` and `end = rounds[last]`.
2. If `start <= end`: return `[start, start+1, ..., end]`.
3. Else: return `[1, 2, ..., end] + [start, start+1, ..., n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — building the result list |
| Space | O(n) — output list |
