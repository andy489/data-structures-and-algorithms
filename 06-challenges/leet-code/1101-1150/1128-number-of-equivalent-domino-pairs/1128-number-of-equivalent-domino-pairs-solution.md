# 1128. Number of Equivalent Domino Pairs — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-equivalent-domino-pairs/

---

## Solution: Canonical Key Count — O(n) time, O(1) space

**Idea:** Normalize each domino so that the smaller value comes first (canonical form). Count occurrences of each canonical pair. For every group of `k` identical dominoes, `k*(k-1)/2` pairs can be formed. Accumulate as we go: when we see a domino whose canonical form has appeared `c` times before, it contributes `c` new pairs.

**Algorithm:**
1. For each domino `[a, b]`, form a canonical key: `min(a,b) * 10 + max(a,b)` (values 1–9, so key fits in 2 digits).
2. Maintain a count array of size 100.
3. For each domino, add `count[key]` to the answer, then increment `count[key]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — fixed-size array of 100 entries |
