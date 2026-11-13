# 45. Jump Game II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/jump-game-ii/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:**

We don't need to track which exact index we jump to — only the farthest index reachable within the current jump's range. Greedily, we always jump to whichever position within our current range extends our reach the furthest.

Think of it in "levels": the current jump covers indices `[curStart..curEnd]`. As we scan through those indices, we track the farthest we could reach from any of them (`farthest`). When we reach `curEnd` we must take another jump — that jump's range is `[curEnd+1..farthest]`.

**Algorithm:**
1. If `n == 1`, return 0 (already there).
2. Track `jumps = 0`, `curEnd = 0` (end of current jump's range), `farthest = 0`.
3. For each index `i` from `0` to `n - 2`:
   - Update `farthest = max(farthest, i + nums[i])`.
   - When `i == curEnd`: we've exhausted the current jump's range, must jump — `jumps++`, `curEnd = farthest`.
   - If `curEnd >= n - 1`: stop early, we can reach the end.
4. Return `jumps`.

**Example trace:** `nums = [2,3,1,1,4]`

```
i=0: farthest=max(0,0+2)=2; i==curEnd(0) → jump#1, curEnd=2
i=1: farthest=max(2,1+3)=4; i<curEnd(2)
i=2: farthest=max(4,2+1)=4; i==curEnd(2) → jump#2, curEnd=4 ≥ 4 → stop
```

Answer: **2**

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the array |
| Space | O(1) — three integer variables |
