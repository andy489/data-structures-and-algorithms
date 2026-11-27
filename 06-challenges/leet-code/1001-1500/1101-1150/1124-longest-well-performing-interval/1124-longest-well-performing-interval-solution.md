# 1124. Longest Well-Performing Interval — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-well-performing-interval/

---

## Solution: Prefix Score + Hash Map — O(n) time, O(n) space

**Idea:** Convert hours to a score array where tiring days contribute `+1` and non-tiring days contribute `-1`. We need the longest subarray with positive sum. Compute prefix sums; for each index `i` with `score > 0`, the answer is `i + 1`. Otherwise, check if `score - 1` appeared earlier (the first occurrence stored in a hash map), because a subarray from that earlier index + 1 to `i` would have sum exactly `+1 > 0`.

**Algorithm:**
1. For each day, add `+1` if `hours[i] > 8`, else `-1`, accumulating a running `score`.
2. Store the first occurrence of each score value in a map `seen`.
3. If `score > 0`, the entire prefix `[0..i]` is well-performing: update `ans = i + 1`.
4. If `score - 1` is in `seen`, update `ans = max(ans, i - seen[score - 1])`.
5. Record `score` in `seen` only if it hasn't been seen before (keep the first/leftmost occurrence).

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — hash map of prefix scores |
