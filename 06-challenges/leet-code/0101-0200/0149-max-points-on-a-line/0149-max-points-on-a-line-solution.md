# 149. Max Points on a Line — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/max-points-on-a-line/

---

## Solution: Slope HashMap per Anchor — O(n²) time, O(n) space

**Idea:** For each point `i` as an anchor, count how many other points share the same slope from `i`. Use a `HashMap<slope_key → count>`. The maximum count + 1 (for the anchor itself) is the line length through `i`.

**Key detail — slope representation:** Avoid floating-point by storing slope as a reduced fraction `(dy/gcd, dx/gcd)` with a canonical sign (denominator ≥ 0). Vertical lines get key `(1, 0)`.

**Algorithm:**
1. For each anchor index `i`:
   - Build a slope map `{slope → count}` over all `j > i`.
   - Track the maximum count across all slopes.
2. Answer is `maxCount + 1` (anchor included), or `1` if only one point.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — n anchors × n slope computations |
| Space | O(n) — slope map for one anchor at a time |
