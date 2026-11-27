# 1024. Video Stitching — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/video-stitching/

---

## Solution: Greedy Jump Game — O(n + time) time, O(time) space

**Idea:** Precompute for each start position the maximum end reachable. Then greedily extend coverage as far as possible.

**Algorithm:**
1. maxEnd[i] = max end for all clips starting at i.
2. Scan: curEnd = farthest reachable so far, nextEnd = max we can reach.
3. When we reach curEnd, we must use another clip; if no progress, return -1.

**Complexity:**

| | |
|---|---|
| Time | O(n + time) |
| Space | O(time) |
