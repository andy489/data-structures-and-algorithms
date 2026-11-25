# 1014. Best Sightseeing Pair — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/best-sightseeing-pair/

---

## Solution: One Pass — O(n) time, O(1) space

**Idea:** Rewrite score as (values[i] + i) + (values[j] - j). Keep running max of (values[i]+i) as we scan j.

**Algorithm:**
1. maxI = values[0] + 0.
2. For j from 1 to n-1: ans = max(ans, maxI + values[j] - j); maxI = max(maxI, values[j] + j).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
