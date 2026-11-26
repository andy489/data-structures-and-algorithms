# 2028. Find Missing Observations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-missing-observations/

---

## Solution: Math — O(m + n) time, O(n) space

**Idea:** The n missing rolls must sum to `(m+n)*mean - sum(rolls)`. Distribute evenly.

**Algorithm:**
1. Compute needed sum = (m+n)*mean - sum(rolls).
2. If needed < n or needed > 6*n, return [].
3. Distribute: base = needed/n, rem = needed%n. First rem rolls get base+1, rest get base.

**Complexity:**

| | |
|---|---|
| Time | O(m + n) |
| Space | O(n) |
