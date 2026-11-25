# 888. Fair Candy Swap — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/fair-candy-swap/

---

## Solution: HashSet — O(m + n) time, O(n) space

**Idea:** Let sumA and sumB be totals. After exchange a↔b: sumA - a + b = sumB - b + a → b = a + (sumB - sumA)/2. For each a in aliceSizes, check if b exists in bobSet.

**Complexity:**

| | |
|---|---|
| Time | O(m + n) |
| Space | O(n) — bob's set |
