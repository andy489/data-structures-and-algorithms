# 1840. Maximum Building Height — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-building-height/

---

## Solution: Two-Pass Restriction Propagation — O(r log r) time, O(r) space

**Idea:** Add sentinel restrictions `[1, 0]` and `[n, n-1]`. Sort by building id. Propagate constraints left-to-right to tighten each restriction by what is reachable from the left: `maxH[i] = min(maxH[i], maxH[i-1] + (id[i] - id[i-1]))`. Then propagate right-to-left similarly.

After both passes, the tallest building between adjacent restricted buildings `i` and `i+1` can be computed: the peak height between positions `a` (height `ha`) and `b` (height `hb`) is `(ha + hb + (b - a)) / 2`.

**Algorithm:**
1. Add `[1, 0]` and `[n, n-1]` to restrictions, sort by id.
2. Left pass: for `i` from 1 to end: `r[i][1] = min(r[i][1], r[i-1][1] + r[i][0] - r[i-1][0])`.
3. Right pass: for `i` from end-2 to 0: `r[i][1] = min(r[i][1], r[i+1][1] + r[i+1][0] - r[i][0])`.
4. For each consecutive pair `(a, ha)` and `(b, hb)`: peak = `(ha + hb + b - a) / 2`.
5. Return max peak.

**Complexity:**

| | |
|---|---|
| Time | O(r log r) — sorting; passes are O(r) |
| Space | O(r) — restriction array |
