# 3096. Minimum Levels to Gain More Points — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-levels-to-gain-more-points/

---

## Solution: Prefix Sum — O(n) time, O(1) space

**Idea:** Compute total score. Alice plays first k levels, Bob plays remaining n-k. Alice's score = prefix[k], Bob's = total - prefix[k]. Find minimum k where prefix[k] > total - prefix[k], i.e., 2*prefix[k] > total.

**Algorithm:**
1. Convert to scores: +1 for 1, -1 for 0.
2. total = sum of all scores.
3. prefix = 0. For k=1..n-1: prefix += score[k-1]. If 2*prefix > total: return k.
4. Return -1.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
