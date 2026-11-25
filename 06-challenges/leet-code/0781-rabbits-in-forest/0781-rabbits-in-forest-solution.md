# 781. Rabbits in Forest — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rabbits-in-forest/

---

## Solution: Greedy Grouping — O(n) time, O(n) space

**Idea:** Rabbits that answer `k` belong to groups of size `k+1`. Count how many times each answer appears. For answer `k` appearing `cnt` times, we need `ceil(cnt / (k+1))` groups, each contributing `k+1` rabbits.

**Algorithm:**
1. Count frequencies of each answer.
2. For each answer `k` with count `cnt`: add `ceil(cnt / (k+1)) * (k+1)` to result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — count frequencies then iterate |
| Space | O(n) — frequency map |
